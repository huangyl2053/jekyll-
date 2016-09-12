var DBZ;
(function (DBZ) {
    (function (ShikakuHenkoRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgHenko = function () {
                return "onSelect_dgHenko";
            };

            Events.onSelectByDblClick_dgHenko = function () {
                return "onSelectByDblClick_dgHenko";
            };

            Events.onSelectByModifyButton_dgHenko = function () {
                return "onSelectByModifyButton_dgHenko";
            };

            Events.onSelectByDeleteButton_dgHenko = function () {
                return "onSelectByDeleteButton_dgHenko";
            };

            Events.onBlur_txtHenkoDate = function () {
                return "onBlur_txtHenkoDate";
            };

            Events.onClick_btnHenkoKakutei = function () {
                return "onClick_btnHenkoKakutei";
            };

            Events.onClick_btnHenkoTorikeshi = function () {
                return "onClick_btnHenkoTorikeshi";
            };
            return Events;
        })();
        ShikakuHenkoRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikakuHenkoRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShikakuHenkoRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShikakuHenkoRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikakuHenkoRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgHenko = function () {
                return new UZA.DataGrid(this.convFiledName("dgHenko"));
            };

            Controls.prototype.HenkoInput = function () {
                return new UZA.Panel(this.convFiledName("HenkoInput"));
            };

            Controls.prototype.txtHenkoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHenkoDate"));
            };

            Controls.prototype.txtHenkoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHenkoTodokedeDate"));
            };

            Controls.prototype.ddlHenkoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoJiyu"));
            };

            Controls.prototype.HenkoHokenshaJoho = function () {
                return new UZA.Panel(this.convFiledName("HenkoHokenshaJoho"));
            };

            Controls.prototype.ddlHenkoSochimotoHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoSochimotoHokensha"));
            };

            Controls.prototype.ddlHenkoKyuHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoKyuHokensha"));
            };

            Controls.prototype.ddlJuminJoho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJuminJoho"));
            };

            Controls.prototype.btnHenkoKakutei = function () {
                return new UZA.Button(this.convFiledName("btnHenkoKakutei"));
            };

            Controls.prototype.btnHenkoTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnHenkoTorikeshi"));
            };
            return Controls;
        })();
        ShikakuHenkoRireki.Controls = Controls;
    })(DBZ.ShikakuHenkoRireki || (DBZ.ShikakuHenkoRireki = {}));
    var ShikakuHenkoRireki = DBZ.ShikakuHenkoRireki;
})(DBZ || (DBZ = {}));
