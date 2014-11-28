var DBC;
(function (DBC) {
    (function (ShinseishaInfo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShinseishaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShinseishaInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ShinseishaInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ShinseishaInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShinseishaInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            };

            Controls.prototype.txtUketsukeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeYMD"));
            };

            Controls.prototype.radShinseishaKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShinseishaKubun"));
            };

            Controls.prototype.txtShinseishaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtAddress = function () {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.btnSearchJigyosha = function () {
                return new UZA.Button(this.convFiledName("btnSearchJigyosha"));
            };
            return Controls;
        })();
        ShinseishaInfo.Controls = Controls;
    })(DBC.ShinseishaInfo || (DBC.ShinseishaInfo = {}));
    var ShinseishaInfo = DBC.ShinseishaInfo;
})(DBC || (DBC = {}));
