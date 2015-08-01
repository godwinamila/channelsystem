<%--
  Created by IntelliJ IDEA.
  User: chamindah
  Date: 7/31/2015
  Time: 11:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<section class="user-reg-box content-box">
  <h3>Register User</h3>

  <form name="reg-user-form">
    <table class="form-table">
      <tr>
        <td>Name: </td>
        <td>
          <input type="text" name="firstname" placeholder="First Name" />
        </td>
        <td>
          <input type="text" name="lastname" placeholder="Last Name" />
        </td>
      </tr>
      <tr>
        <td>NIC No:</td>
        <td colspan="2">
          <input type="text" name="nic" placeholder="**********V" />
        </td>
      </tr>
      <tr>
        <td>Email:</td>
        <td colspan="2">
          <input type="text" name="email" />
        </td>
      </tr>
      <tr>
        <td>Telephone:</td>
        <td colspan="2">
          <input type="text" name="tp" placeholder="(0**) *** ****" />
        </td>
      </tr>
      <tr>
        <td>Password:</td>
        <td colspan="2">
          <input type="password" name="password" />
        </td>
      </tr>
      <tr>
        <td>Confirm Password:</td>
        <td colspan="2">
          <input type="password" name="confpassword" />
        </td>
      </tr>
      <tr>
        <td></td>
        <td colspan="2">
          <input type="submit" value="Register" />
        </td>
      </tr>
    </table>

  </form>
</section>

<!-- success message -->
<section class="success-msg">
  <p>This is the success message</p>
</section>

<!-- doctor search -->
<section class="search-doc-box content-box">
  <h3>Search Doctor</h3>

  <form name="search-doc-form">
    <table class="form-table">
      <tr>
        <td>
          Last Name:
        </td>
        <td>
          <input type="text" name="lastname" />
        </td>
      </tr>
      <tr>
        <td>Speciality:</td>
        <td>
          <select name="specialty">
            <option>Physician</option>
            <option>Surgon</option>
          </select>
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="submit" value="Search..." />
        </td>
      </tr>
    </table>
  </form>

  <table class="tab-doc-search-res tab-alt">
    <thead>
    <tr>
      <th>Name</th>
      <th>Specialty</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>Dr. A B C De Silva</td>
      <td>Physician</td>
      <td><a href="#">Book Now</a></td>
    </tr>
    <tr>
      <td>Dr. Kamal Perera</td>
      <td>Physician</td>
      <td><a href="#">Book Now</a></td>
    </tr>
    <tr>
      <td>Dr. Nihal Goonaratne</td>
      <td>Surgeon</td>
      <td><a href="#">Book Now</a></td>
    </tr>
    <tr>
      <td>Prof. A N C Wijerathne</td>
      <td>Physician</td>
      <td><a href="#">Book Now</a></td>
    </tr>
    </tbody>
  </table>

</section>


<!-- patient search -->
<section class="search-pat-box content-box">
  <h3>Search Patients</h3>

  <form name="pat-search-form">
    <table class="form-table">
      <tr>
        <td>Last Name: </td>
        <td>
          <input type="text" name="lastname" />
        </td>
      </tr>
      <tr>
        <td>NIC No: </td>
        <td>
          <input type="text" name="nic" />
        </td>
      </tr>
      <tr>
        <td>Telephone: </td>
        <td>
          <input type="text" name="telephone" />
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="submit" value="Search..." />
        </td>
      </tr>
    </table>
  </form>

  <table class="tab-search-pat-res tab-alt">
    <thead>
    <tr>
      <th>Name</th>
      <th>NIC No.</th>
      <th>Telephone</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>Mr. J K S Perera</td>
      <td>875412563V</td>
      <td>(071) 325 7788</td>
      <td><a href="#">View</a></td>
    </tr>
    <tr>
      <td>Mrs. Kamala Ranasinghe</td>
      <td>571254251V</td>
      <td>(077) 123 1521</td>
      <td><a href="#">View</a></td>
    </tr>
    <tr>
      <td>Mrs. Priyanthi Gunawardhana</td>
      <td>648575251V</td>
      <td>(071) 654 1245</td>
      <td><a href="#">View</a></td>
    </tr>
    <tr>
      <td>Mr. K M L Amarasinghe</td>
      <td>804125425V</td>
      <td>(011) 852 7254</td>
      <td><a href="#">View</a></td>
    </tr>
    <tr>
      <td>Mr. U W Pieris</td>
      <td>7821544433V</td>
      <td>(011) 285 1254</td>
      <td><a href="#">View</a></td>
    </tr>
    </tbody>
  </table>
</section>

<!-- patient details -->
<section class="pat-view-box content-box">
  <h3>Patient Details</h3>

  <!-- general details -->
  <table class="tab-info">
    <tr>
      <td>
        <label>Name: </label>
      </td>
      <td>James Bond</td>
    </tr>
    <tr>
      <td>
        <label>Gender: </label>
      </td>
      <td>Male</td>
    </tr>
    <tr>
      <td>
        <label>NIC No:</label>
      </td>
      <td>543423439V</td>
    </tr>
    <tr>
      <td>
        <label>Telephone: </label>
      </td>
      <td>(077) 234 5678</td>
    </tr>

  </table>

  <!-- history -->

  <table class="tab-history tab-alt">
    <thead>
    <tr>
      <th>Date</th>
      <th>Doctor</th>
      <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>2015-Jan-18</td>
      <td>A B C De Silva <small>Consultant physician</small></td>
      <td>
        <p>
          <strong>Symptoms: </strong> Lorem ipsum dolor sit amet
        </p>
        <p>
          <strong>Prescription: </strong> Lorem ipsum dolor sit amet
        </p>
        <p>
          <strong>Remarks: </strong> Lorem ipsum dolor sit amet
        </p>
      </td>
    </tr>
    <tr>
      <td>2015-Jan-18</td>
      <td>A B C De Silva <small>Consultant physician</small></td>
      <td>
        <p>
          <strong>Symptoms: </strong> Lorem ipsum dolor sit amet
        </p>
        <p>
          <strong>Prescription: </strong> Lorem ipsum dolor sit amet
        </p>
        <p>
          <strong>Remarks: </strong> Lorem ipsum dolor sit amet
        </p>
      </td>
    </tr>
    <tr>
      <td>2015-Jan-18</td>
      <td>A B C De Silva <small>Consultant physician</small></td>
      <td>
        <p>
          <strong>Symptoms: </strong> Lorem ipsum dolor sit amet
        </p>
        <p>
          <strong>Prescription: </strong> Lorem ipsum dolor sit amet
        </p>
        <p>
          <strong>Remarks: </strong> Lorem ipsum dolor sit amet
        </p>
      </td>
    </tr>
    <tr>
      <td>2015-Jan-18</td>
      <td>A B C De Silva <small>Consultant physician</small></td>
      <td>
        <p>
          <strong>Symptoms: </strong> Lorem ipsum dolor sit amet
        </p>
        <p>
          <strong>Prescription: </strong> Lorem ipsum dolor sit amet
        </p>
        <p>
          <strong>Remarks: </strong> Lorem ipsum dolor sit amet
        </p>
      </td>
    </tr>
    </tbody>
  </table>
</section>
</body>
</html>
