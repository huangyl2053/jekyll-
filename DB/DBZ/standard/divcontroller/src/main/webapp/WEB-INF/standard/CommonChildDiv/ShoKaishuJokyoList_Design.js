var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoList) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgShoKaishuJokyo = function () {
                return "onSelect_dgShoKaishuJokyo";
            };

            Events.onSelectBySelectButton_dgShoKaishuJokyo = function () {
                return "onSelectBySelectButton_dgShoKaishuJokyo";
            };
            return Events;
        })();
        ShoKaishuJokyoList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShoKaishuJokyoList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShoKaishuJokyoList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShoKaishuJokyoList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShoKaishuJokyoList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgShoKaishuJokyo = function () {
                return new UZA.DataGrid(this.convFiledName("dgShoKaishuJokyo"));
            };

            Controls.prototype.ShoKaishuJokyoShosai = function () {
                return new UZA.Panel(this.convFiledName("ShoKaishuJokyoShosai"));
            };

            Controls.prototype.txtShoKofuShurui = function () {
                return new UZA.TextBox(this.convFiledName("txtShoKofuShurui"));
            };

            Controls.prototype.txtKofuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            };

            Controls.prototype.txtYukoKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKigen"));
            };

            Controls.prototype.txtKofuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtKofuJiyu"));
            };

            Controls.prototype.txtKofuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKofuRiyu"));
            };

            Controls.prototype.txtKaishuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaishuDate"));
            };

            Controls.prototype.ddlKaishuJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaishuJiyu"));
            };

            Controls.prototype.txtKaishuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuRiyu"));
            };
            return Controls;
        })();
        ShoKaishuJokyoList.Controls = Controls;
    })(DBZ.ShoKaishuJokyoList || (DBZ.ShoKaishuJokyoList = {}));
    var ShoKaishuJokyoList = DBZ.ShoKaishuJokyoList;
})(DBZ || (DBZ = {}));
