/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820027;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)のバリデーションチェッククラスです。
 *
 * @reamsid_L DBC-1030-060 tangkai
 */
public enum KinkyujiShisetuRyoyohiPanelSpec implements IPredicate<KinkyujiShisetuRyoyohiPanelDiv> {

    /**
     * 緊急時傷病名2の入力チェック
     */
    緊急時傷病名2の入力チェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !((div.getTxtKinkyuShobyoName2().getValue() == null || div.getTxtKinkyuShobyoName2().getValue().isEmpty())
                    && div.getTxtKinkyuJiryoStartYMD2().getValue() != null);
        }
    },
    /**
     * 緊急時治療開始日2の入力チェック
     */
    緊急時治療開始日2の入力チェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !((div.getTxtKinkyuShobyoName2().getValue() != null && !div.getTxtKinkyuShobyoName2().getValue().isEmpty())
                    && div.getTxtKinkyuJiryoStartYMD2().getValue() == null);
        }
    },
    /**
     * 緊急時傷病名3の入力チェック
     */
    緊急時傷病名3の入力チェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !((div.getTxtKinkyuShobyoName3().getValue() == null || div.getTxtKinkyuShobyoName3().getValue().isEmpty())
                    && div.getTxtKinkyuJiryoStartYMD3().getValue() != null);
        }
    },
    /**
     * 緊急時治療開始日3の入力チェック
     */
    緊急時治療開始日3の入力チェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !((div.getTxtKinkyuShobyoName3().getValue() != null && !div.getTxtKinkyuShobyoName3().getValue().isEmpty())
                    && div.getTxtKinkyuJiryoStartYMD3().getValue() == null);
        }
    },
    /**
     * 往診日数の入力チェック
     */
    往診日数の入力チェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !(div.getTxtOshinNissu().getValue() == null && !RString.isNullOrEmpty(div.getTxtOshinYiryokikanName().getValue()));
        }
    },
    /**
     * 往診医療機関名の入力チェック
     */
    往診医療機関名の入力チェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !(div.getTxtOshinNissu().getValue() != null && RString.isNullOrEmpty(div.getTxtOshinYiryokikanName().getValue()));
        }
    },
    /**
     * 通院日数の入力チェック
     */
    通院日数の入力チェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !(div.getTxtTuyinNissu().getValue() == null && !RString.isNullOrEmpty((div.getTxtTuyinYiryokikanName().getValue())));
        }
    },
    /**
     * 通院医療機関名の入力チェック
     */
    通院医療機関名の入力チェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !(div.getTxtTuyinNissu().getValue() != null && RString.isNullOrEmpty(div.getTxtTuyinYiryokikanName().getValue()));
        }
    },
    /**
     * 緊急時治療管理単位数の入力チェック
     */
    緊急時治療管理単位数の入力チェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !(div.getTxtkinkyuChiryoKanriTanisu().getValue() == null && div.getTxtkinkyuChiryoKanriNissu().getValue() != null);
        }
    },
    /**
     * 緊急時治療管理日数の入力チェック
     */
    緊急時治療管理日数の入力チェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !(div.getTxtkinkyuChiryoKanriTanisu().getValue() != null && div.getTxtkinkyuChiryoKanriNissu().getValue() == null);
        }
    },
    /**
     * 緊急時治療管理小計のチェック
     */
    緊急時治療管理小計のチェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !(div.getTxtkinkyuChiryoKanriTanisu().getValue() != null && div.getTxtkinkyuChiryoKanriNissu().getValue() != null
                    && (div.getTxtkinkyuChiryoKanriSubTotal().getValue() == null || div.getTxtkinkyuChiryoKanriSubTotal().getValue().equals(Decimal.ZERO)));
        }
    },
    /**
     * 特定治療合計のチェック
     */
    特定治療合計のチェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !((div.getTxtrehabilitationTanisu().getValue() != null || div.getTxtshujutsuTanisu().getValue() != null
                    || div.getTxtHoshasenChiryoTanisu().getValue() != null || div.getTxtShochiTanisu().getValue() != null
                    || div.getTxtMasuiTanisu().getValue() != null) && (div.getTxtKinkyuShisetsuRyoyohiTotalTanisu().getValue() == null
                    || div.getTxtKinkyuShisetsuRyoyohiTotalTanisu().getValue().equals(Decimal.ZERO)));
        }
    },
    /**
     * 証明書入力済チェック
     */
    証明書入力済チェック {
        @Override
        public boolean apply(KinkyujiShisetuRyoyohiPanelDiv div) {
            return !div.getHdnShomeishoKanryoFlag().equals(ShomeishoNyuryokuKanryoKubunType.入力未完了.getCode());
        }

    };

}
