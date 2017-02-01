/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.errorlist;

import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;
import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.OcrTorikomiKekkaCsvEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.util.accesslog.ExpandedInformations;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Seireki;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * OCRの取込結果です。
 */
public final class OcrTorikomiResult {

    private final RDate 取込日;
    private final OCRID ocrid;
    private final SheetID sheetID;
    private final ShinseiKey key;
    private final RString 氏名;
    private final RString 氏名カナ;
    private final ShinkiKoshinKubun 新規更新区分;
    private final IProcessingResult 処理結果;

    private OcrTorikomiResult(Builder builder) {
        this.取込日 = builder.取込日;
        this.ocrid = builder.ocrid;
        this.sheetID = builder.sheetID;
        this.key = builder.key;
        this.氏名 = builder.氏名;
        this.氏名カナ = builder.氏名カナ;
        this.新規更新区分 = builder.新規更新区分;
        this.処理結果 = builder.処理結果;
    }

    OcrTorikomiKekkaCsvEntity toEntity() {
        OcrTorikomiKekkaCsvEntity entity = new OcrTorikomiKekkaCsvEntity();
        entity.set取込日西暦(toSlashSeparated(this.取込日.seireki()));
        entity.setOcrID(this.ocrid.value());
        entity.set帳票連番(this.sheetID.value());
        entity.set証記載保険者番号(this.key.get証記載保険者番号());
        FlexibleDate shinseiYmd = this.key.get認定申請日AsFlexibleDate();
        entity.set申請日西暦(shinseiYmd.isValid() ? toSlashSeparated(shinseiYmd.seireki()) : RString.EMPTY);
        entity.set被保険者番号(this.key.get被保険者番号());
        entity.set氏名(this.氏名);
        entity.set氏名カナ(this.氏名カナ);
        entity.set新規更新区分(this.新規更新区分.toRString());
        entity.set結果(this.処理結果.type().getName());
        entity.set備考(処理結果.note());
        return null;
    }

    private static RString toSlashSeparated(Seireki seireki) {
        return seireki.separator(Separator.SLASH).fillType(FillType.NONE).toDateString();
    }

    PersonalData toPersonalData() {
        return PersonalData.of(ShikibetsuCode.EMPTY, // TODO 何を指定するのか？？？
                ExpandedInformations.証記載保険者番号.fromValue(this.key.get被保険者番号()),
                ExpandedInformations.被保険者番号.fromValue(this.key.get被保険者番号()),
                ExpandedInformations.申請書管理番号.fromValue(RString.EMPTY) //TOOD 申請書管理番号
        );
    }

    /**
     * {@link OcrTorikomiResult}を生成します。
     */
    public static class Builder {

        private final RDate 取込日;
        private final OCRID ocrid;
        private final SheetID sheetID;
        private final ShinseiKey key;
        private RString 氏名 = RString.EMPTY;
        private RString 氏名カナ = RString.EMPTY;
        private ShinkiKoshinKubun 新規更新区分 = ShinkiKoshinKubun.対象データなし;
        private IProcessingResult 処理結果;

        /**
         * {@link Builder}を生成します。
         *
         * @param 取込日 取込日
         * @param ocrID OCRID
         * @param sheetID SheetID
         * @param key {@link ShinseiKey 申請のキー}
         */
        public Builder(RDate 取込日, OCRID ocrID, SheetID sheetID, ShinseiKey key) {
            this.取込日 = 取込日;
            this.ocrid = ocrID;
            this.sheetID = sheetID;
            this.key = key;
        }

        /**
         * @param 氏名 氏名
         * @param 氏名カナ 氏名カナ
         * @param 新規更新区分 新規更新区分
         * @return {@link Builder}
         */
        public Builder set関連データ(RString 氏名, RString 氏名カナ, ShinkiKoshinKubun 新規更新区分) {
            this.氏名 = 氏名;
            this.氏名カナ = 氏名カナ;
            this.新規更新区分 = 新規更新区分;
            return this;
        }

        /**
         * @param 処理結果 {@link IProcessingResult}
         * @return {@link Builder}
         */
        public Builder set処理結果(IProcessingResult 処理結果) {
            this.処理結果 = 処理結果;
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
