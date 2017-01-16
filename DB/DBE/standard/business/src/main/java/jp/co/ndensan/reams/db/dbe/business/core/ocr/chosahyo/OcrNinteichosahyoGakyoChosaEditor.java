/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link DbT5302ShujiiIkenshoJohoEntity}を編集します。
 */
public final class OcrNinteichosahyoGakyoChosaEditor {

    private OcrNinteichosahyoGakyoChosaEditor() {
    }

    /**
     * @param entity {@link DbT5202NinteichosahyoGaikyoChosaEntity}
     * @param ocrChosa {@link OcrChosa}
     * @return
     * 指定の{@link DbT5202NinteichosahyoGaikyoChosaEntity}を{@link OcrChosa}の内容で編集したインスタンス
     */
    public static DbT5202NinteichosahyoGaikyoChosaEntity edit(DbT5202NinteichosahyoGaikyoChosaEntity entity, OcrChosa ocrChosa) {
        for (Editor editor : Editor.values()) {
            RString value = editor.getValueFrom(ocrChosa);
            if (RString.isNullOrEmpty(value)) {
                continue;
            }
            editor.set(value, entity);
        }
        return entity;
    }

    private enum Editor {

        実施日 {
                    @Override
                    RString getValueFrom(OcrChosa ocrChosa) {
                        return ocrChosa.get実施日時();
                    }

                    @Override
                    void set(RString value, DbT5202NinteichosahyoGaikyoChosaEntity entity) {
                        entity.setNinteichosaJisshiYMD(new FlexibleDate(value));
                    }
                },
        調査員コード {
                    @Override
                    RString getValueFrom(OcrChosa ocrChosa) {
                        return ocrChosa.get記入者();
                    }

                    @Override
                    void set(RString value, DbT5202NinteichosahyoGaikyoChosaEntity entity) {
                        entity.setChosainCode(value);
                    }
                },
        調査委託先コード {
                    @Override
                    RString getValueFrom(OcrChosa ocrChosa) {
                        return ocrChosa.get所属機関();
                    }

                    @Override
                    void set(RString value, DbT5202NinteichosahyoGaikyoChosaEntity entity) {
                        entity.setChosaItakusakiCode(new JigyoshaNo(value));
                    }
                },
        サービス区分コード {
                    @Override
                    RString getValueFrom(OcrChosa ocrChosa) {
                        return ocrChosa.getサービス区分コード();
                    }

                    @Override
                    void set(RString value, DbT5202NinteichosahyoGaikyoChosaEntity entity) {
                        if (new RString("3").equals(value)) {
                            entity.setServiceKubunCode(new Code("9"));
                            return;
                        }
                        entity.setServiceKubunCode(new Code(value));
                    }
                },
        実施場所コード {
                    @Override
                    RString getValueFrom(OcrChosa ocrChosa) {
                        return ocrChosa.get実施場所();
                    }

                    @Override
                    void set(RString value, DbT5202NinteichosahyoGaikyoChosaEntity entity) {
                        entity.setChosaJisshiBashoCode(new Code(value));
                    }
                };

        abstract RString getValueFrom(OcrChosa ocrChosa);

        abstract void set(RString value, DbT5202NinteichosahyoGaikyoChosaEntity entity);

        private static final RString TRUE = new RString("1");

        protected boolean toBoolean(RString value) {
            return TRUE.equals(value);
        }
    }
}
