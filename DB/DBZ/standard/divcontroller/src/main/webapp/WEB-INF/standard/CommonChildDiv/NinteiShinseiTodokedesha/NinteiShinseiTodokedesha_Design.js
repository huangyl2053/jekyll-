var DBZ;
(function (DBZ) {
    (function (NinteiShinseiTodokedesha) {
        var Events = (function () {
            function Events() {
            }
            Events.onChanged_ddlTodokedeDaikoKubun = function () {
                return "onChanged_ddlTodokedeDaikoKubun";
            };

            Events.onOkClose_seitai = function () {
                return "onOkClose_seitai";
            };

            Events.onOkClose_atenKensaku = function () {
                return "onOkClose_atenKensaku";
            };

            Events.onClick_btnZenkaiFukusha = function () {
                return "onClick_btnZenkaiFukusha";
            };

            Events.onChangeChkKannaiKangai = function () {
                return "onChangeChkKannaiKangai";
            };
            return Events;
        })();
        NinteiShinseiTodokedesha.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiShinseiTodokedesha";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiShinseiTodokedesha.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiShinseiTodokedesha.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiShinseiTodokedesha = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlTodokledeDaikoKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTodokledeDaikoKubun"));
            };

            Controls.prototype.btnSetaiIchiran = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSetaiIchiran"));
            };

            Controls.prototype.btnAtenaKensaku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnAtenaKensaku"));
            };

            Controls.prototype.btnZenkaiFukusha = function () {
                return new UZA.Button(this.convFiledName("btnZenkaiFukusha"));
            };

            Controls.prototype.ccdShisetsuJohoCommonChildDiv = function () {
                return new DBZ.ShisetsuJohoCommonChildDiv.ModeController(this.convFiledName("ccdShisetsuJohoCommonChildDiv"));
            };

            Controls.prototype.ddlShinseiKankeisha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiKankeisha"));
            };

            Controls.prototype.txtShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            };

            Controls.prototype.txtKanaShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtKanaShimei"));
            };

            Controls.prototype.txtHonninKankeisei = function () {
                return new UZA.TextBox(this.convFiledName("txtHonninKankeisei"));
            };

            Controls.prototype.radKannaiKangai = function () {
                return new UZA.RadioButton(this.convFiledName("radKannaiKangai"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.ccdChoikiInput = function () {
                return new URA.ChoikiInput.ModeController(this.convFiledName("ccdChoikiInput"));
            };

            Controls.prototype.ccdZenkokuJushoInput = function () {
                return new URZ.ZenkokuJushoInput.ModeController(this.convFiledName("ccdZenkokuJushoInput"));
            };
            return Controls;
        })();
        NinteiShinseiTodokedesha.Controls = Controls;
    })(DBZ.NinteiShinseiTodokedesha || (DBZ.NinteiShinseiTodokedesha = {}));
    var NinteiShinseiTodokedesha = DBZ.NinteiShinseiTodokedesha;
})(DBZ || (DBZ = {}));
