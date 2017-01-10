/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link DbT5302ShujiiIkenshoJohoEntity}を編集します。
 */
public final class OcrShujiiIkenshoJohoEditor {

    private OcrShujiiIkenshoJohoEditor() {
    }

    /**
     * @param entity {@link DbT5302ShujiiIkenshoJohoEntity}
     * @param ocrIken {@link OcrIken}
     * @return
     * 指定の{@link DbT5302ShujiiIkenshoJohoEntity}を{@link OcrIken}の内容で編集したインスタンス
     */
    public static DbT5302ShujiiIkenshoJohoEntity edit(DbT5302ShujiiIkenshoJohoEntity entity, OcrIken ocrIken) {
        for (Editor editor : Editor.values()) {
            RString value = editor.getValueFrom(ocrIken);
            if (RString.isNullOrEmpty(value)) {
                continue;
            }
            editor.set(value, entity);
        }
        return entity;
    }

    private enum Editor {

        受領日 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get受領日();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setIkenshoJuryoYMD(new FlexibleDate(value));
                    }
                },
        記入日 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get記入日();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setIkenshoKinyuYMD(new FlexibleDate(value));
                    }
                },
        意見書作成回数区分 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get意見書作成回数();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setIkenshoSakuseiKaisuKubun(new Code(value));
                    }
                },
        意見書同意フラグ {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get同意の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setIkenshoDoiFlag(toBoolean(value));
                    }
                },
        最終診療日 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get最終診察日();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setSaishuShinryoYMD(new FlexibleDate(value));
                    }
                },
        他科受診の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get他科受診の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistTakaJushinFlag(toBoolean(value));
                    }
                },
        内科受診の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get内科受診の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistNaikaJushinFlag(toBoolean(value));
                    }
                },
        精神科受診の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get精神科受診の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistSeishinkaJushinFlag(toBoolean(value));
                    }
                },
        外科受診の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get外科受診の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistGekaJushinFlag(toBoolean(value));
                    }
                },
        整形外科受診の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get整形外科受診の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistSeikeigekaJushinFlag(toBoolean(value));
                    }
                },
        脳神経外科の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get脳神経外科の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistNoshinkeigekaJushinFlag(toBoolean(value));
                    }
                },
        皮膚科受診の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get皮膚科受診の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistHifukaJushinFlag(toBoolean(value));
                    }
                },
        泌尿器科受診の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get泌尿器科受診の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistHinyokikaJushinFlag(toBoolean(value));
                    }
                },
        婦人科受診の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get婦人科受診の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistFujinkaJushinFlag(toBoolean(value));
                    }
                },
        耳鼻咽喉科受診の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get耳鼻咽喉科受診の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistJibiinkokaJushinFlag(toBoolean(value));
                    }
                },
        リハビリテーション科受診の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.getリハビリテーション科受診の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistRehabilitationkaJushinFlag(toBoolean(value));
                    }
                },
        歯科受診の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get歯科受診の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistShikaJushinFlag(toBoolean(value));
                    }
                },
        眼科の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get眼科の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistGankaJushinFlag(toBoolean(value));
                    }
                },
        その他受診科の有無 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.getその他受診科の有無();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setExistSonotaJushinkaFlag(toBoolean(value));
                    }
                },
        発症年月日１ {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get発症年月日１();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setHasshoYMD1(value);
                    }
                },
        発症年月日２ {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get発症年月日２();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setHasshoYMD2(value);
                    }
                },
        発症年月日３ {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get発症年月日３();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setHasshoYMD3(value);
                    }
                },
        症状の安定性 {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get症状の安定性();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setAnteisei(value);
                    }
                },
        二次判定結果連絡フラグ {
                    @Override
                    RString getValueFrom(OcrIken ocrIken) {
                        return ocrIken.get主治医への結果連絡();
                    }

                    @Override
                    void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity) {
                        entity.setNijiHanteiKekkaRenrakuFlag(toBoolean(value));
                    }
                };

        abstract RString getValueFrom(OcrIken ocrIken);

        abstract void set(RString value, DbT5302ShujiiIkenshoJohoEntity entity);

        private static final RString TRUE = new RString("1");

        protected boolean toBoolean(RString value) {
            return TRUE.equals(value);
        }
    }
}
