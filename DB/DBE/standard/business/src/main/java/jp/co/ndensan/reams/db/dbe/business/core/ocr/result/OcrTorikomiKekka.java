/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.result;

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
public final class OcrTorikomiKekka {

    private final RDate 取込日;
    private final OCRID ocrid;
    private final SheetID sheetID;
    private final ShinseiKey key;
    private final RString 氏名;
    private final RString 氏名カナ;
    private final ShinkiKoshinKubun 新規更新区分;
    private final boolean succeeds;
    private final int 取込イメージ件数;
    private final RString エラー内容;

    private OcrTorikomiKekka(Builder builder) {
        this.取込日 = builder.取込日;
        this.ocrid = builder.ocrid;
        this.sheetID = builder.sheetID;
        this.key = builder.key;
        this.氏名 = builder.氏名;
        this.氏名カナ = builder.氏名カナ;
        this.新規更新区分 = builder.新規更新区分;
        this.succeeds = builder.succeeds;
        this.取込イメージ件数 = builder.取込イメージ件数;
        this.エラー内容 = builder.エラー内容;
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
        entity.set結果(this.succeeds ? new RString("正常終了") : new RString("エラー"));
        entity.set取込イメージ件数(this.取込イメージ件数);
        entity.setエラー内容(エラー内容);
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
     * {@link OcrTorikomiKekka}を生成します。
     */
    public static class Builder {

        private final RDate 取込日;
        private final OCRID ocrid;
        private final SheetID sheetID;
        private final ShinseiKey key;
        private RString 氏名 = RString.EMPTY;
        private RString 氏名カナ = RString.EMPTY;
        private ShinkiKoshinKubun 新規更新区分 = ShinkiKoshinKubun.対象データなし;
        private boolean succeeds;
        private int 取込イメージ件数 = 0;
        private RString エラー内容 = RString.EMPTY;

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
         * @param 取込イメージ件数 イメージの数
         * @return {@link OcrTorikomiKekka}
         */
        public OcrTorikomiKekka success(int 取込イメージ件数) {
            this.succeeds = true;
            this.取込イメージ件数 = 取込イメージ件数;
            return new OcrTorikomiKekka(this);
        }

        /**
         * @param エラー内容 エラー内容
         * @return {@link OcrTorikomiKekka}
         */
        public OcrTorikomiKekka error(RString エラー内容) {
            this.succeeds = false;
            this.エラー内容 = エラー内容;
            return new OcrTorikomiKekka(this);
        }
    }
}
