package ldap

import (
	"testing"

	"fmt"

	"github.com/HariniGB/login-provider/common"
	"github.com/stretchr/testify/assert"
)

func TestLdapConnect(t *testing.T) {
	l, err := NewLdap("admin", "mysecretpassword", "127.0.0.1",
		389, "dc=ldap,dc=s3u,dc=rl", "foo", "bar")
	assert.Nil(t, err)

	user := &common.User{
		Username:  "vija",
		Password:  "october19",
		FirstName: "Vijay",
		LastName:  "Samuel",
		Email:     "vjsamuel1990@gmail.com",
	}
	l.AddUser(user)
	l.AddGroup("foo")
	l.AddUserToGroup("foo", "vija")
	l.DeleteUser("vija1")
	//l.DeleteGroup("foo")
	conn, err := l.loginUser("vija", "october19")
	if err != nil {
		fmt.Println(err)
	} else {
		conn.Close()
	}
	fmt.Println(l.GetUsersFromGroup("foo"))
	fmt.Println(l.GetUsersGroups("vija"))
	fmt.Println(l.ExistsUser("vija"))
	fmt.Println(l.ExistsUser("vija1"))

	//user.LastName = "Sam"
	//l.UpdateUser(user)
}
