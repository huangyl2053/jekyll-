var DBZ;
(function (DBZ) {
    (function (IryoHokenRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddIryoHoken = function () {
                return "onClick_btnAddIryoHoken";
            };

            Events.onSelect_dgIryoHokenRireki = function () {
                return "onSelect_dgIryoHokenRireki";
            };

            Events.onSelectByDbClick_dgIryoHokenRireki = function () {
                return "onSelectByDbClick_dgIryoHokenRireki";
            };

            Events.onSelectByModifyButton_dgIryoHokenRireki = function () {
                return "onSelectByModifyButton_dgIryoHokenRireki";
            };

            Events.onSelectByDeleteButton_dgIryoHokenRireki = function () {
                return "onSelectByDeleteButton_dgIryoHokenRireki";
            };

            Events.onBlur_txtIryoHokenHokenshaNo = function () {
                return "onBlur_txtIryoHokenHokenshaNo";
            };

            Events.onClick_btnIryoHokenKakutei = function () {
                return "onClick_btnIryoHokenKakutei";
            };

            Events.onClick_btnIryoHokenTorikeshi = function () {
                return "onClick_btnIryoHokenTorikeshi";
            };
            return Events;
        })();
        IryoHokenRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IryoHokenRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IryoHokenRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddIryoHoken = function () {
                return new UZA.Button(this.convFiledName("btnAddIryoHoken"));
            };

            Controls.prototype.dgIryoHokenRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgIryoHokenRireki"));
            };

            Controls.prototype.IryoHokenInput = function () {
                return new UZA.Panel(this.convFiledName("IryoHokenInput"));
            };

            Controls.prototype.txtIryoHokenKanyuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenKanyuDate"));
            };

            Controls.prototype.txtIryoHokenDattaiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenDattaiDate"));
            };

            Controls.prototype.ddlIryoHokenShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIryoHokenShubetsu"));
            };

            Controls.prototype.txtIryoHokenHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoHokenHokenshaNo"));
            };

            Controls.prototype.txtIryoHokenHokenshaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenHokenshaMeisho"));
            };

            Controls.prototype.txtIryoHokenKigoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenKigoNo"));
            };

            Controls.prototype.btnIryoHokenKakutei = function () {
                return new UZA.Button(this.convFiledName("btnIryoHokenKakutei"));
            };

            Controls.prototype.btnIryoHokenTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnIryoHokenTorikeshi"));
            };
            return Controls;
        })();
        IryoHokenRireki.Controls = Controls;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));
