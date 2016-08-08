/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1060001;

import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1060001.GemmenGengakuShoIkkatsuMainHandler.SelectKey;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免減額帳票一括のバリデーションクラスです。
 *
 * @reamsid_L DBD-3981-010 zhuxiaojun
 */
public enum GemmenGengakuShoIkkatsuMainDivSpec implements IPredicate<GemmenGengakuShoIkkatsuMainDiv> {

    出力の選択チェック {
                /**
                 * 出力の選択チェックです。
                 *
                 * @param div 減免減額帳票一括画面Div
                 * @return true:出力が選択しています、false:今回開始時間が選択されていません。
                 */
                @Override
                public boolean apply(GemmenGengakuShoIkkatsuMainDiv div) {
                    boolean 出力Falg1 = false;
                    boolean 出力Falg2 = false;
                    RString taishoKey = div.getSakuseiTaisho().getDdlGemmenGengakuShurui().getSelectedKey();
                    if (taishoKey.equals(SelectKey.key0.getValue())) {
                        出力Falg1 = div.getFutanGendogaku().getFutanGendogakuNinteisho().isIsPublish();
                        出力Falg2 = div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().isIsPublish();
                    } else {
                        出力Falg1 = div.getShafukuKeigen().getShafukuKeigenKakuninSho().isIsPublish();
                        出力Falg2 = div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().isIsPublish();
                    }

                    return 出力Falg1 && 出力Falg2;
                }
            },
    交付日の非空チェック {
                /**
                 * 交付日の非空チェックです。
                 *
                 * @param div 減免減額帳票一括画面Div
                 * @return true:交付日が非空です、false:交付日が空です。
                 */
                @Override
                public boolean apply(GemmenGengakuShoIkkatsuMainDiv div) {
                    boolean 非空Falg = false;
                    RString shakaiKey = div.getSakuseiTaisho().getDdlGemmenGengakuShurui().getSelectedKey();
                    if (div.getSakuseiTaisho().getDdlGemmenGengakuShurui().getSelectedValue().equals(GemmenGengakuShurui.負担限度額認定.get名称())
                    && div.getFutanGendogaku().getFutanGendogakuNinteisho().getTxtFutanGendogakuNinteishoKofuYmd() != null
                    && div.getFutanGendogaku().getFutanGendogakuNinteisho().getTxtFutanGendogakuNinteishoKofuYmd().getValue().isValid()) {
                        非空Falg = true;
                    }
                    if (shakaiKey.equals(SelectKey.key1.getValue())
                    && div.getShafukuKeigen().getShafukuKeigenKakuninSho().getTxtShafukuKeigenKakuninShoKofuYmd() != null
                    && div.getShafukuKeigen().getShafukuKeigenKakuninSho().getTxtShafukuKeigenKakuninShoKofuYmd().getValue().isValid()) {
                        非空Falg = true;
                    }
                    return 非空Falg;
                }

            },
    発行日の非空チェック {
                /**
                 * 発行日の非空チェックです。
                 *
                 * @param div 減免減額帳票一括画面Div
                 * @return true:発行日が非空です、false:発行日が空です。
                 */
                @Override
                public boolean apply(GemmenGengakuShoIkkatsuMainDiv div) {
                    boolean 非空Falg = false;
                    if (div.getSakuseiTaisho().getDdlGemmenGengakuShurui().getSelectedValue().equals(GemmenGengakuShurui.負担限度額認定.get名称())
                    && div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().getTxtFutanGendogakuKetteiTsuchishoHakkoYmd() != null
                    && div.getFutanGendogaku()
                    .getFutanGendogakuKetteiTsuchisho().getTxtFutanGendogakuKetteiTsuchishoHakkoYmd().getValue().isValid()) {
                        非空Falg = true;
                    }
                    if (div.getSakuseiTaisho().getDdlGemmenGengakuShurui().getSelectedKey().
                    equals(SelectKey.key1.getValue())
                    && div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().getTxtShafukuKeigenKetteiTsuchishoHakkoYmd() != null
                    && div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().getTxtShafukuKeigenKetteiTsuchishoHakkoYmd().getValue().isValid()) {
                        非空Falg = true;
                    }
                    return 非空Falg;
                }
            },
    文書番号の設定チェック {
                /**
                 * 文書番号の設定チェックです。
                 *
                 * @param div 減免減額帳票一括画面Div
                 * @return true: 文書番号が設定です、false: 文書番号が設定ないです。
                 */
                @Override
                public boolean apply(GemmenGengakuShoIkkatsuMainDiv div) {
                    boolean 設定Flag = false;
                    if (div.getSakuseiTaisho().getDdlGemmenGengakuShurui().getSelectedValue().equals(GemmenGengakuShurui.負担限度額認定.get名称())
                    && !div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho()
                    .getCcdFutanGendogakuKetteiTsuchishoBunshoNo().get文書番号().isNull()
                    && !div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho()
                    .getCcdFutanGendogakuKetteiTsuchishoBunshoNo().get文書番号().isEmpty()
                    && !div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho()
                    .getCcdFutanGendogakuKetteiTsuchishoBunshoNo().get文書番号().toString().equals("第号")) {
                        設定Flag = true;
                    }
                    if (div.getSakuseiTaisho().getDdlGemmenGengakuShurui().getSelectedKey().equals(SelectKey.key1.getValue())
                    && !div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho()
                    .getCcdShafukuKeigenKetteiTsuchishoBunshoNo().get文書番号().isNull()
                    && !div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho()
                    .getCcdShafukuKeigenKetteiTsuchishoBunshoNo().get文書番号().trim().isEmpty()
                    && !div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho()
                    .getCcdShafukuKeigenKetteiTsuchishoBunshoNo().get文書番号().toString().equals("第号")) {
                        設定Flag = true;
                    }

                    return 設定Flag;
                }
            },
    対象日Fromの時間チェック {
                /**
                 * 対象日Fromの時間チェックです。
                 *
                 * @param div 減免減額帳票一括画面Div
                 * @return true:対象日Fromの時間が正しいです、false:発行日が間違いです。
                 */
                @Override
                public boolean apply(GemmenGengakuShoIkkatsuMainDiv div) {
                    boolean 結果Falg = false;
                    if (div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdTo().getValue() == null
                    || div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdFrom().getValue() == null) {
                        return 結果Falg;
                    }
                    if (!div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdTo().getValue().isValid()
                    || !div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdFrom().getValue().isValid()) {
                        return 結果Falg;
                    }
                    if (div.getSakuseiTaisho().getDdlGemmenGengakuShurui().getSelectedValue().equals(GemmenGengakuShurui.負担限度額認定.get名称())
                    && (div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdFrom().getValue()
                    .compareTo(div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdTo().getValue()) <= 0)) {
                        結果Falg = true;
                    }

                    return 結果Falg;
                }
            },
    決定日Fromの時間チェック {
                /**
                 * 決定日Fromの時間チェックです。
                 *
                 * @param div 減免減額帳票一括画面Div
                 * @return true:決定日Fromの時間が正しいです、false:決定日が間違いです。
                 */
                @Override
                public boolean apply(GemmenGengakuShoIkkatsuMainDiv div) {
                    boolean 結果Falg = false;
                    if (div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenKonkaiTaishoYmdFrom().getValue() == null
                    || div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenKonkaiTaishoYmdTo().getValue() == null) {
                        return 結果Falg;
                    }
                    if (!div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenKonkaiTaishoYmdFrom().getValue().isValid()
                    || !div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenKonkaiTaishoYmdTo().getValue().isValid()) {
                        return 結果Falg;
                    }
                    if (div.getSakuseiTaisho().getDdlGemmenGengakuShurui()
                    .getSelectedKey().equals(SelectKey.key1.getValue())
                    && (div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenKonkaiTaishoYmdFrom().getValue()
                    .compareTo(div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenKonkaiTaishoYmdTo().getValue()) <= 0)) {
                        結果Falg = true;
                    }

                    return 結果Falg;
                }
            },
}
