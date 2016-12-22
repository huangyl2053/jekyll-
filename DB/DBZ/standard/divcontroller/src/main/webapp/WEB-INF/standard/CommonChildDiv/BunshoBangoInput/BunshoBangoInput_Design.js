var DBZ;
(function (DBZ) {
    (function (BunshoBangoInput) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_BtnGetBunshoNo = function () {
                return "onClick_BtnGetBunshoNo";
            };
            return Events;
        })();
        BunshoBangoInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "BunshoBangoInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.BunshoBangoInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.BunshoBangoInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.BunshoBangoInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtBunshoKigo = function () {
                return new UZA.TextBox(this.convFiledName("txtBunshoKigo"));
            };

            Controls.prototype.txtBunshoHeader = function () {
                return new UZA.TextBox(this.convFiledName("txtBunshoHeader"));
            };

            Controls.prototype.txtBunshoNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtBunshoNo"));
            };

            Controls.prototype.txtBunshoFooter = function () {
                return new UZA.TextBox(this.convFiledName("txtBunshoFooter"));
            };

            Controls.prototype.btnGetBunshoNo = function () {
                return new UZA.Button(this.convFiledName("btnGetBunshoNo"));
            };
            return Controls;
        })();
        BunshoBangoInput.Controls = Controls;
    })(DBZ.BunshoBangoInput || (DBZ.BunshoBangoInput = {}));
    var BunshoBangoInput = DBZ.BunshoBangoInput;
})(DBZ || (DBZ = {}));
