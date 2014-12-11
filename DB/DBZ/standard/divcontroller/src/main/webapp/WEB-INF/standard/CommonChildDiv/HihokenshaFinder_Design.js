var DBZ;
(function (DBZ) {
    (function (HihokenshaFinder) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnToClear = function () {
                return "onClick_btnToClear";
            };
            return Events;
        })();
        HihokenshaFinder.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HihokenshaFinder";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HihokenshaFinder.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HihokenshaFinder.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HihokenshaFinder = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.SearchCriteriaOfHihokensha = function () {
                return new UZA.Panel(this.convFiledName("SearchCriteriaOfHihokensha"));
            };

            Controls.prototype.ddlHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokensha"));
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtTuchishoNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtTuchishoNo"));
            };

            Controls.prototype.ddlFukaNendo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlFukaNendo"));
            };

            Controls.prototype.SearchCriteriaDetail = function () {
                return new UZA.Panel(this.convFiledName("SearchCriteriaOfHihokensha_SearchCriteriaDetail"));
            };

            Controls.prototype.chkHihokensha = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHihokensha"));
            };

            Controls.prototype.radMinashiNigo = function () {
                return new UZA.RadioButton(this.convFiledName("radMinashiNigo"));
            };

            Controls.prototype.chkMinashiNigo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMinashiNigo"));
            };

            Controls.prototype.KaigoAtenaFinder = function () {
                return new URA.AtenaFinder.ModeController(this.convFiledName("KaigoAtenaFinder"));
            };

            Controls.prototype.ButtonsForHihokenshaFinder = function () {
                return new UZA.Panel(this.convFiledName("ButtonsForHihokenshaFinder"));
            };

            Controls.prototype.btnToClear = function () {
                return new UZA.Button(this.convFiledName("btnToClear"));
            };

            Controls.prototype.btnToSearch = function () {
                return new UZA.Button(this.convFiledName("btnToSearch"));
            };

            Controls.prototype.txtMaxNumber = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxNumber"));
            };

            Controls.prototype.saikinShorisha = function () {
                return new DBZ.KaigoSaikinShorishaRireki.ModeController(this.convFiledName("saikinShorisha"));
            };
            return Controls;
        })();
        HihokenshaFinder.Controls = Controls;
    })(DBZ.HihokenshaFinder || (DBZ.HihokenshaFinder = {}));
    var HihokenshaFinder = DBZ.HihokenshaFinder;
})(DBZ || (DBZ = {}));
