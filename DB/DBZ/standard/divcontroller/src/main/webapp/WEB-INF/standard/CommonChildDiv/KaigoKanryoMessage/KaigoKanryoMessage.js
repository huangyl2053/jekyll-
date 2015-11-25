var DBZ;
(function (DBZ) {
    (function (KaigoKanryoMessage) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoKanryoMessage.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "SizeType",
                    "MessageType",
                    "ResultType"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoKanryoMessage.PublicProperties(this.fieldName);
            };

            ModeController.prototype.ResultType = function () {
                return new Modes.ResultType(this.controls);
            };

            ModeController.prototype.MessageType = function () {
                return new Modes.MessageType(this.controls);
            };

            ModeController.prototype.SizeType = function () {
                return new Modes.SizeType(this.controls);
            };
            return ModeController;
        })();
        KaigoKanryoMessage.ModeController = ModeController;

        (function (Modes) {
            var ResultType = (function () {
                function ResultType(controls) {
                    this.controls = controls;
                }
                ResultType.prototype.Success = function () {
                    this.controls.ccdKanryoMessage().ResultType().Success();
                };

                ResultType.prototype.Error = function () {
                    this.controls.ccdKanryoMessage().ResultType().Error();
                };
                return ResultType;
            })();
            Modes.ResultType = ResultType;

            var MessageType = (function () {
                function MessageType(controls) {
                    this.controls = controls;
                }
                MessageType.prototype.Nomal = function () {
                    this.controls.ccdKanryoMessage().MessageType().Nomal();
                };

                MessageType.prototype.Empty = function () {
                    this.controls.ccdKanryoMessage().MessageType().Empty();
                };
                return MessageType;
            })();
            Modes.MessageType = MessageType;

            var SizeType = (function () {
                function SizeType(controls) {
                    this.controls = controls;
                }
                SizeType.prototype.Normal = function () {
                    this.controls.ccdKanryoMessage().SizeType().Normal();
                };

                SizeType.prototype.Small = function () {
                    this.controls.ccdKanryoMessage().SizeType().Small();
                };
                return SizeType;
            })();
            Modes.SizeType = SizeType;
        })(KaigoKanryoMessage.Modes || (KaigoKanryoMessage.Modes = {}));
        var Modes = KaigoKanryoMessage.Modes;
    })(DBZ.KaigoKanryoMessage || (DBZ.KaigoKanryoMessage = {}));
    var KaigoKanryoMessage = DBZ.KaigoKanryoMessage;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoKanryoMessage) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoKanryoMessage.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoKanryoMessage.PublicProperties = PublicProperties;
    })(DBZ.KaigoKanryoMessage || (DBZ.KaigoKanryoMessage = {}));
    var KaigoKanryoMessage = DBZ.KaigoKanryoMessage;
})(DBZ || (DBZ = {}));
