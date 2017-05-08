/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijihanteisumidataif;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataIDataShutsuryokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataIferaEucEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 一次判定済みデータインターフェースを編集します。
 */
public class IchijiHanteiSumiDataIFEditor {

    private static final IResult EMPTY_RESULT;
    private static final Set<KoroshoIfShikibetsuCode> OPERATABLE_CODES;

    static {
        EMPTY_RESULT = new _EmptyResult();

        Set<KoroshoIfShikibetsuCode> set = new HashSet<>();
        set.add(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3);
        set.add(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009);
        OPERATABLE_CODES = Collections.unmodifiableSet(set);
    }

    private final RString fileName09A;
    private final RString fileName09B;

    /**
     * インスタンスを生成します。
     *
     * @param operationDate 処理日付
     */
    public IchijiHanteiSumiDataIFEditor(RDate operationDate) {
        RDate shoriDate = operationDate;
        this.fileName09A = DbBusinessConfig.get(ConfigNameDBE.認定ソフト審査会資料作成用データ送信ファイル名09A, shoriDate);
        this.fileName09B = DbBusinessConfig.get(ConfigNameDBE.認定ソフト審査会資料作成用データ送信ファイル名09B, shoriDate);
    }

    /**
     * @param in {@link IchijihanteiSumidataIDataShutsuryokuRelateEntity}
     * @return {@link IResult}
     */
    public IResult edit(IchijihanteiSumidataIDataShutsuryokuRelateEntity in) {
        if (!KoroshoIfShikibetsuCode.existsCode(in.get厚労省IF識別コード())) {
            return EMPTY_RESULT;
        }
        KoroshoIfShikibetsuCode koroshoIfCode = KoroshoIfShikibetsuCode.toValue(in.get厚労省IF識別コード());
        if (!OPERATABLE_CODES.contains(koroshoIfCode)) {
            return EMPTY_RESULT;
        }
        RString errorDetail = findError(koroshoIfCode, in);
        if (!RString.isNullOrEmpty(errorDetail)) {
            return new _Error(in, koroshoIfCode, errorDetail);
        }
        switch (koroshoIfCode) {
            case 認定ｿﾌﾄ2009_SP3:
                return new _09B(in);
            case 認定ｿﾌﾄ2009:
                return new _09A(in);
            default:
                return EMPTY_RESULT;
        }
    }

    private static RString findError(KoroshoIfShikibetsuCode koroshoIfCode, IchijihanteiSumidataIDataShutsuryokuRelateEntity in) {
        switch (koroshoIfCode) {
            case 認定ｿﾌﾄ2009_SP3:
                return new IchijihanteiSumidataIferaBunisess().setエラーデータ09B(in);
            case 認定ｿﾌﾄ2009:
                return new IchijihanteiSumidataIferaBunisess().setエラーデータ09A(in);
            default:
                return RString.EMPTY;
        }
    }

    /**
     * 編集結果であることを表します。
     */
    public static interface IResult {

        /**
         * @return ファイル名
         */
        RString getFileName();

        /**
         * @return 編集結果の{@link IchijihanteiSumidataEucEntity}
         */
        IchijihanteiSumidataEucEntity createCsvEntity();

        /**
         * @return 編集結果が存在する場合、{@code true}.
         */
        boolean exists();
    }

    private final class _09A implements IResult {

        private final IchijihanteiSumidataIDataShutsuryokuRelateEntity in;

        private _09A(IchijihanteiSumidataIDataShutsuryokuRelateEntity in) {
            this.in = in;
        }

        @Override
        public RString getFileName() {
            return fileName09B;
        }

        @Override
        public IchijihanteiSumidataEucEntity createCsvEntity() {
            return new IchijihanteiSumidataIfBunisess().set一次判定済データ09A(this.in);
        }

        @Override
        public boolean exists() {
            return true;
        }

    }

    private final class _09B implements IResult {

        private final IchijihanteiSumidataIDataShutsuryokuRelateEntity in;

        private _09B(IchijihanteiSumidataIDataShutsuryokuRelateEntity in) {
            this.in = in;
        }

        @Override
        public RString getFileName() {
            return fileName09A;
        }

        @Override
        public IchijihanteiSumidataEucEntity createCsvEntity() {
            return new IchijihanteiSumidataIfBunisess().set一次判定済データ09B(this.in);
        }

        @Override
        public boolean exists() {
            return true;
        }

    }

    private static final class _EmptyResult implements IResult {

        @Override
        public RString getFileName() {
            return RString.EMPTY;
        }

        @Override
        public IchijihanteiSumidataEucEntity createCsvEntity() {
            return new IchijihanteiSumidataEucEntity() {
            };
        }

        @Override
        public boolean exists() {
            return false;
        }

    }

    private static final class _Error implements IResult {

        private static final RString FILE_NAME_09B = new RString("IchijiHanteiErr_09B.CSV");
        private static final RString FILE_NAME_09A = new RString("IchijiHanteiErr_09A.CSV");
        private final IchijihanteiSumidataIDataShutsuryokuRelateEntity in;
        private final RString fileName;
        private final RString errorDetail;

        private _Error(IchijihanteiSumidataIDataShutsuryokuRelateEntity in, KoroshoIfShikibetsuCode koroshoIfShikibetsuCode, RString errorDetail) {
            this.in = in;
            this.fileName = findFileName(koroshoIfShikibetsuCode);
            this.errorDetail = errorDetail;
        }

        private static RString findFileName(KoroshoIfShikibetsuCode koroshoIfShikibetsuCode) {
            switch (koroshoIfShikibetsuCode) {
                case 認定ｿﾌﾄ2009_SP3:
                    return FILE_NAME_09B;
                case 認定ｿﾌﾄ2009:
                    return FILE_NAME_09A;
                default:
                    throw new SystemException("処理対象外の厚労省IF識別コードです。");
            }
        }

        @Override
        public RString getFileName() {
            return this.fileName;
        }

        @Override
        public IchijihanteiSumidataEucEntity createCsvEntity() {
            IchijihanteiSumidataIferaEucEntity out = new IchijihanteiSumidataIferaEucEntity();
            out.set保険者番号(this.in.get保険者番号());
            out.set被保険者番号(this.in.get被保険者番号());
            out.setエラー項目(this.errorDetail);
            return out;
        }

        @Override
        public boolean exists() {
            return true;
        }

    }

}
