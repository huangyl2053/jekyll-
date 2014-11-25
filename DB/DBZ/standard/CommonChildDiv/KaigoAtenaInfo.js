var DBZ;
(function (DBZ) {
    (function (KaigoAtenaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoAtenaInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KaigoAtenaInfo.ModeController = ModeController;
    })(DBZ.KaigoAtenaInfo || (DBZ.KaigoAtenaInfo = {}));
    var KaigoAtenaInfo = DBZ.KaigoAtenaInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoAtenaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoAtenaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.priorities = function () {
                return [
                    "DisplayType",
                    "BtnDainoninDisplay",
                    "BtnSofusakiDisplay",
                    "BtnKozaDisplay",
                    "BtnSetaiDisplay",
                    "BtnEltaxDisplay",
                    "BtnAtesakiDisplay"
                ];
            };

            PublicProperties.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };

            PublicProperties.prototype.BtnDainoninDisplay = function () {
                return new Modes.BtnDainoninDisplay(this.controls);
            };

            PublicProperties.prototype.BtnSofusakiDisplay = function () {
                return new Modes.BtnSofusakiDisplay(this.controls);
            };

            PublicProperties.prototype.BtnKozaDisplay = function () {
                return new Modes.BtnKozaDisplay(this.controls);
            };

            PublicProperties.prototype.BtnSetaiDisplay = function () {
                return new Modes.BtnSetaiDisplay(this.controls);
            };

            PublicProperties.prototype.BtnEltaxDisplay = function () {
                return new Modes.BtnEltaxDisplay(this.controls);
            };

            PublicProperties.prototype.BtnAtesakiDisplay = function () {
                return new Modes.BtnAtesakiDisplay(this.controls);
            };
            return PublicProperties;
        })();
        KaigoAtenaInfo.PublicProperties = PublicProperties;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.一行タイプ = function () {
                    this.controls.atenaInfo().DisplayType().一行タイプ();
                };

                DisplayType.prototype.三行タイプ = function () {
                    this.controls.atenaInfo().DisplayType().三行タイプ();
                };

                DisplayType.prototype.指定無し = function () {
                    this.controls.atenaInfo().DisplayType().指定無し();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;

            var BtnDainoninDisplay = (function () {
                function BtnDainoninDisplay(controls) {
                    this.controls = controls;
                }
                BtnDainoninDisplay.prototype.指定無し = function () {
                    this.controls.atenaInfo().BtnDainoninDisplay().指定無し();
                };
                BtnDainoninDisplay.prototype.表示しない = function () {
                    this.controls.atenaInfo().BtnDainoninDisplay().表示しない();
                };
                return BtnDainoninDisplay;
            })();
            Modes.BtnDainoninDisplay = BtnDainoninDisplay;

            var BtnSofusakiDisplay = (function () {
                function BtnSofusakiDisplay(controls) {
                    this.controls = controls;
                }
                BtnSofusakiDisplay.prototype.指定無し = function () {
                    this.controls.atenaInfo().BtnSofusakiDisplay().指定無し();
                };
                BtnSofusakiDisplay.prototype.表示しない = function () {
                    this.controls.atenaInfo().BtnSofusakiDisplay().表示しない();
                };
                return BtnSofusakiDisplay;
            })();
            Modes.BtnSofusakiDisplay = BtnSofusakiDisplay;

            var BtnKozaDisplay = (function () {
                function BtnKozaDisplay(controls) {
                    this.controls = controls;
                }
                BtnKozaDisplay.prototype.指定無し = function () {
                    this.controls.atenaInfo().BtnKozaDisplay().指定無し();
                };
                BtnKozaDisplay.prototype.表示しない = function () {
                    this.controls.atenaInfo().BtnKozaDisplay().表示しない();
                };
                return BtnKozaDisplay;
            })();
            Modes.BtnKozaDisplay = BtnKozaDisplay;

            var BtnSetaiDisplay = (function () {
                function BtnSetaiDisplay(controls) {
                    this.controls = controls;
                }
                BtnSetaiDisplay.prototype.指定無し = function () {
                    this.controls.atenaInfo().BtnSetaiDisplay().指定無し();
                };
                BtnSetaiDisplay.prototype.表示しない = function () {
                    this.controls.atenaInfo().BtnSetaiDisplay().表示しない();
                };
                return BtnSetaiDisplay;
            })();
            Modes.BtnSetaiDisplay = BtnSetaiDisplay;

            var BtnEltaxDisplay = (function () {
                function BtnEltaxDisplay(controls) {
                    this.controls = controls;
                }
                BtnEltaxDisplay.prototype.指定無し = function () {
                    this.controls.atenaInfo().BtnEltaxDisplay().指定無し();
                };
                BtnEltaxDisplay.prototype.表示しない = function () {
                    this.controls.atenaInfo().BtnEltaxDisplay().表示しない();
                };
                return BtnEltaxDisplay;
            })();
            Modes.BtnEltaxDisplay = BtnEltaxDisplay;

            var BtnAtesakiDisplay = (function () {
                function BtnAtesakiDisplay(controls) {
                    this.controls = controls;
                }
                BtnAtesakiDisplay.prototype.指定無し = function () {
                    this.controls.atenaInfo().BtnAtesakiDisplay().指定無し();
                };
                BtnAtesakiDisplay.prototype.表示しない = function () {
                    this.controls.atenaInfo().BtnAtesakiDisplay().表示しない();
                };
                return BtnAtesakiDisplay;
            })();
            Modes.BtnAtesakiDisplay = BtnAtesakiDisplay;
        })(KaigoAtenaInfo.Modes || (KaigoAtenaInfo.Modes = {}));
        var Modes = KaigoAtenaInfo.Modes;
    })(DBZ.KaigoAtenaInfo || (DBZ.KaigoAtenaInfo = {}));
    var KaigoAtenaInfo = DBZ.KaigoAtenaInfo;
})(DBZ || (DBZ = {}));
