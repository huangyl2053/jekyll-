/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijihanteiresult;

import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定で利用する引数から値を取得するためのクラスです。
 *
 * @author n8178
 */
public class IchijiHanteiArgumentConverter {

    private static final int ARGUMENT_LENGTH = 5;

    /**
     * 一次判定DLLから戻ってきた値を、個別のデータに切り分けるために使用する文字です。
     */
    private enum SplitString {

        /**
         * 複数の対象者を一括で一次判定した場合に、区切りとして使用される文字列
         */
        ARGMENT_SPLIT("\\|"),
        /**
         * 一次判定データの区切りとして使用される文字列
         */
        DATA_SPLIT("\\,");

        private final RString value;

        private SplitString(String str) {
            this.value = new RString(str);
        }

        public RString value() {
            return value;
        }
    }

    private enum HanteiArgumentPoint {

        /**
         * 基本調査項目の位置を示します。
         */
        基本調査項目(0),
        /**
         * 主治医意見書項目の位置を示します。
         */
        主治医意見書項目(1),
        /**
         * 障害高齢者自立度の位置を示します。
         */
        障害高齢者自立度(2),
        /**
         * 認知症高齢者自立度の位置を示します。
         */
        認知症高齢者自立度(3),
        /**
         * 認知症高齢者自立度（主治医意見書）の位置を示します。
         */
        認知症高齢者自立度_主治医意見書(4);

        private final int value;

        private HanteiArgumentPoint(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

    private final RString hanteiArgument;

    /**
     * コンストラクタです。複数件分に相当する一次判定引数を渡した場合は、先頭1件分のみ処理対象とします。
     *
     * @param hanteiArgument 一次判定引数
     */
    public IchijiHanteiArgumentConverter(RString hanteiArgument) {
        Objects.requireNonNull(hanteiArgument);

        List<RString> argumentList = hanteiArgument.split(SplitString.ARGMENT_SPLIT.value.toString());
        if (argumentList.isEmpty()) {
            this.hanteiArgument = hanteiArgument;
        } else {
            this.hanteiArgument = argumentList.get(0);
        }
    }

    /**
     * 一次判定引数から、認定調査における認知症高齢者自立度コードを取得します。
     *
     * @return 認知症高齢者自立度コード
     */
    public RString get認知症高齢者自立度コード_認定調査() {

        List<RString> hanteiArgumentSplit = hanteiArgument.split(SplitString.DATA_SPLIT.value().toString());
        if (hanteiArgumentSplit == null || hanteiArgumentSplit.size() < ARGUMENT_LENGTH) {
            return RString.EMPTY;
        }
        return hanteiArgumentSplit.get(HanteiArgumentPoint.認知症高齢者自立度.value);
    }

    /**
     * 一次判定引数から、主治医意見書における認知症高齢者自立度コードを取得します。
     *
     * @return 認知症高齢者自立度コード
     */
    public RString get認知症高齢者自立度コード_主治医意見書() {

        List<RString> hanteiArgumentSplit = hanteiArgument.split(SplitString.DATA_SPLIT.value().toString());
        if (hanteiArgumentSplit == null || hanteiArgumentSplit.size() < ARGUMENT_LENGTH) {
            return RString.EMPTY;
        }
        return hanteiArgumentSplit.get(HanteiArgumentPoint.認知症高齢者自立度_主治医意見書.value);
    }
}
