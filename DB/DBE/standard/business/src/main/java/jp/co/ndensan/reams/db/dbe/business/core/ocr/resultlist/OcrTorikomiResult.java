/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.resultlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IRelatedData;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.OcrTorikomiKekkaCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Seireki;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * OCRの取込結果です。
 */
public final class OcrTorikomiResult {

    private final ShinseiKey key;
    private final RString 氏名;
    private final RString 氏名カナ;
    private final RString 申請書管理番号;
    private final IProcessingResults 処理結果;

    private OcrTorikomiResult(Builder builder) {
        this.key = builder.key;
        this.氏名 = builder.氏名;
        this.氏名カナ = builder.氏名カナ;
        this.処理結果 = builder.処理結果;
        this.申請書管理番号 = builder.申請書管理番号;
    }

    Collection<OcrTorikomiKekkaCsvEntity> toEntities() {
        List<IProcessingResult> results = new ArrayList<>(this.処理結果.values());

        Set<OcrTorikomiKekkaCsvEntity> entities = new HashSet<>();
        for (IProcessingResult pr : results) {
            OcrTorikomiKekkaCsvEntity entity = new OcrTorikomiKekkaCsvEntity();
            entity.setOCRID(pr.ocrData().getOCRID().value());
            entity.setSheetID(pr.ocrData().getSheetID().value());
            entity.set証記載保険者番号(this.key.get証記載保険者番号());
            FlexibleDate shinseiYmd = this.key.get認定申請日AsFlexibleDate();
            entity.set申請日西暦(shinseiYmd.isValid() ? toSlashSeparated(shinseiYmd.seireki()) : RString.EMPTY);
            entity.set被保険者番号(this.key.get被保険者番号());
            entity.set氏名(this.氏名);
            entity.set氏名カナ(this.氏名カナ);
            entity.setKekkaCode(pr.type().code());
            entity.set備考(pr.note());
            entity.set申請書管理番号(申請書管理番号);
            entities.add(entity);
        }
        return entities;
    }

    private static RString toSlashSeparated(Seireki seireki) {
        return seireki.separator(Separator.SLASH).fillType(FillType.NONE).toDateString();
    }

    /**
     * {@link OcrTorikomiResult}を生成します。
     */
    public static class Builder {

        private final ShinseiKey key;
        private final ProcessingResults 処理結果;
        private RString 氏名 = RString.EMPTY;
        private RString 氏名カナ = RString.EMPTY;
        private RString 申請書管理番号 = RString.EMPTY;

        /**
         * {@link Builder}を生成します。
         *
         * @param key {@link ShinseiKey 申請のキー}
         */
        public Builder(ShinseiKey key) {
            this.key = key;
            this.処理結果 = new ProcessingResults();
        }

        /**
         * @param 関連データ 関連データ
         * @return {@link Builder}
         */
        public Builder set関連データ(IRelatedData 関連データ) {
            this.氏名 = 関連データ.get被保険者氏名();
            this.氏名カナ = 関連データ.get被保険者カナ();
            this.申請書管理番号 = ObjectUtil.defaultIfNull(関連データ.get申請書管理番号(), ShinseishoKanriNo.EMPTY).value();
            return this;
        }

        /**
         * @param 処理結果 {@link IProcessingResult}
         * @return {@link Builder}
         */
        public Builder set処理結果(IProcessingResult 処理結果) {
            this.処理結果.add(処理結果);
            return this;
        }

        /**
         * @param 処理結果s {@link IProcessingResults}
         * @return {@link Builder}
         */
        public Builder set処理結果s(IProcessingResults 処理結果s) {
            this.処理結果.addAll(処理結果s);
            return this;
        }

        /**
         * @return {@link OcrTorikomiResult}
         */
        public OcrTorikomiResult build() {
            return new OcrTorikomiResult(this);
        }
    }
}
