/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import jp.co.ndensan.reams.db.dbe.business.core.ninteichosakekkatorikomiocr.NinteiOcrRelate;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiMessages;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResultFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResults;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenChosainFuicchi;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocr.OcrDataReadProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosaContextEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.AccessLevel;

/**
 * {@link DbT5202NinteichosahyoGaikyoChosaEntity}を編集します。
 */
public final class OcrNinteichosahyoGakyoChosaEditor {

    private static final RString KINYUSHA_MINYURYOKU = new RString("99999999");

    private OcrNinteichosahyoGakyoChosaEditor() {
    }

    @lombok.AllArgsConstructor
    public static final class Context {

        @lombok.Getter
        private final OcrChosa ocrChosa;
        private final NinteiChosaContextEntity entity;
        private final NinteiOcrRelate relatedData;
        private final OcrDataReadProcessParameter batchParam;

        boolean exsits調査委託先() {
            return entity.getExists調査員区分() != null;
        }

        boolean exisits調査員() {
            if (!exsits調査委託先()) {
                return false;
            }
            return entity.getExists調査員区分();
        }

        TreatmentWhenChosainFuicchi get調査員不一致時処理() {
            return this.batchParam.get調査員不一致時処理方法();
        }

        FlexibleDate get調査依頼日() {
            return this.relatedData.get調査依頼日();
        }

        RString get依頼調査委託先コード() {
            return this.relatedData.get認定調査委託先コード();
        }
    }

    @lombok.Getter
    @lombok.AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Result {

        private final DbT5202NinteichosahyoGaikyoChosaEntity entity;
        private final IProcessingResults results;
    }

    /**
     * @param entity {@link DbT5202NinteichosahyoGaikyoChosaEntity}
     * @param context {@link Context}
     * @return
     * 指定の{@link DbT5202NinteichosahyoGaikyoChosaEntity}を{@link OcrChosa}の内容で編集したインスタンス
     */
    public static DbT5202NinteichosahyoGaikyoChosaEntity edit(DbT5202NinteichosahyoGaikyoChosaEntity entity, Context context) {
        ProcessingResults resutls = new ProcessingResults();
        for (Editor editor : Editor.values()) {
            RString value = editor.getValueFrom(context.getOcrChosa());
            if (RString.isNullOrEmpty(value)) {
                continue;
            }
            editor.set(value, entity);
        }

        if (!context.exsits調査委託先()) {
            resutls.add(ProcessingResultFactory.error(context.getOcrChosa(), OcrTorikomiMessages.TODO));
        }
        if (!context.exisits調査員()) {
            resutls.add(ProcessingResultFactory.error(context.getOcrChosa(), OcrTorikomiMessages.TODO));
        }
        if (!entity.getChosaItakusakiCode().value().equals(context.get依頼調査委託先コード())) {
            resutls.add(ProcessingResultFactory.error(context.getOcrChosa(), OcrTorikomiMessages.TODO));
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

                    @Override
                    IProcessingResults validate(RString value, Context context) {
                        FlexibleDate date = new FlexibleDate(value);
                        if (!context.get調査依頼日().isBeforeOrEquals(date)) {
                            return new ProcessingResults(
                                    ProcessingResultFactory.error(context.getOcrChosa(), OcrTorikomiMessages.TODO)
                            );
                        }
                        return ProcessingResults.EMPTY;
                    }
                },
        調査員コード {
                    @Override
                    RString getValueFrom(OcrChosa ocrChosa) {
                        return ocrChosa.get記入者();
                    }

                    @Override
                    void set(RString value, DbT5202NinteichosahyoGaikyoChosaEntity entity) {
                        if (KINYUSHA_MINYURYOKU.equals(value)) {
                            entity.setChosainCode(RString.EMPTY);
                        } else {
                            entity.setChosainCode(value);
                        }
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

        IProcessingResults validate(RString value, Context context) {
            return ProcessingResults.EMPTY;
        }

        private static final RString TRUE = new RString("1");

        protected boolean toBoolean(RString value) {
            return TRUE.equals(value);
        }
    }
}
