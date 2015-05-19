var DBZ;
(function (DBZ) {
    (function (NinteiShinseiRenrakusakiKihon) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        NinteiShinseiRenrakusakiKihon.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiShinseiRenrakusakiKihon";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiShinseiRenrakusakiKihon.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiShinseiRenrakusakiKihon.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiShinseiRenrakusakiKihon = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            };

            Controls.prototype.ddlTsuzukigara = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTsuzukigara"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtJusho = function () {
                return new UZA.TextBox(this.convFiledName("txtJusho"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtMobileNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtMobileNo"));
            };
            return Controls;
        })();
        NinteiShinseiRenrakusakiKihon.Controls = Controls;
    })(DBZ.NinteiShinseiRenrakusakiKihon || (DBZ.NinteiShinseiRenrakusakiKihon = {}));
    var NinteiShinseiRenrakusakiKihon = DBZ.NinteiShinseiRenrakusakiKihon;
})(DBZ || (DBZ = {}));
