/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKyukaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会の詳細な情報を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public final class ShinsakaiDetail {

    private final ShinsakaiKaisaiNo 審査会開催番号;
    private final FlexibleDate 審査会開催年月日;
    private final TimeString 審査会開始時間;
    private final TimeString 審査会終了時間;
    private final GogitaiDetail 合議体情報;
    private final ShinsakaiKaisaiBasho 審査会開催場所;
    private final int 審査会予定定員;
    private final int 審査会最大定員;
    private final int 審査会自動割当定員;
    private final int 審査会委員定員;
    private final GogitaiSeishinkaIshiSonzaiKubun 合議体精神科医師存在区分;
    private final GogitaiDummyKubun 合議体ダミー区分;
    private final FlexibleDate 審査会資料作成年月日;
    private final ShinsakaiKyukaiKubun 審査会休会区分;
    private final int 審査会割当済み人数;
    private final Code 資料作成区分;

    /**
     * Builderで設定した情報を受け取るコンストラクタです。
     *
     * @param builder 審査会情報Builder
     */
    private ShinsakaiDetail(Builder builder) {
        this.審査会開催番号 = builder.shinsakaiKaisaiNo;
        this.審査会開催年月日 = builder.kaisaiDate;
        this.審査会開始時間 = builder.kaishiTime;
        this.審査会終了時間 = builder.shuryoTime;
        this.合議体情報 = builder.gogitaiDetail;
        this.審査会開催場所 = builder.kaisaiBasho;
        this.審査会予定定員 = builder.plannedTeiin;
        this.審査会最大定員 = builder.maxTeiin;
        this.審査会自動割当定員 = builder.autoWariateTeiin;
        this.審査会委員定員 = builder.memberTeiin;
        this.合議体精神科医師存在区分 = builder.existSeishinkaIshi;
        this.合議体ダミー区分 = builder.gogitaiDummyKubun;
        this.審査会資料作成年月日 = builder.documentationDate;
        this.審査会休会区分 = builder.kyukaiKubun;
        this.審査会割当済み人数 = builder.wariatesumi;
        this.資料作成区分 = builder.shiryoSakuseiKubun;
    }

    /**
     * 審査会開催番号を返します。
     *
     * @return 審査会開催番号
     */
    public ShinsakaiKaisaiNo get審査会開催番号() {
        return 審査会開催番号;
    }

    /**
     * 審査会開催年月日を返します。
     *
     * @return 審査会開催年月日
     */
    public FlexibleDate get審査会開催年月日() {
        return 審査会開催年月日;
    }

    /**
     * 審査会開始時間を返します。
     *
     * @return 審査会開始時間
     */
    public TimeString get審査会開始時間() {
        return 審査会開始時間;
    }

    /**
     * 審査会終了時間を返します。
     *
     * @return 審査会終了時間
     */
    public TimeString get審査会終了時間() {
        return 審査会終了時間;
    }

    /**
     * 合議体情報を返します。
     *
     * @return 合議体情報
     */
    public GogitaiDetail get合議体情報() {
        return 合議体情報;
    }

    /**
     * 審査会開催場所を返します。
     *
     * @return 審査会開催場所
     */
    public ShinsakaiKaisaiBasho get審査会開催場所() {
        return 審査会開催場所;
    }

    /**
     * 審査会予定定員を返します。
     *
     * @return 審査会予定定員
     */
    public int get審査会予定定員() {
        return 審査会予定定員;
    }

    /**
     * 審査会最大定員を返します。
     *
     * @return 審査会最大定員
     */
    public int get審査会最大定員() {
        return 審査会最大定員;
    }

    /**
     * 審査会自動割当定員を返します。
     *
     * @return 審査会自動割当定員
     */
    public int get審査会自動割当定員() {
        return 審査会自動割当定員;
    }

    /**
     * 審査会委員定員を返します。
     *
     * @return 審査会委員定員
     */
    public int get審査会委員定員() {
        return 審査会委員定員;
    }

    /**
     * 精神科医師存在区分を返します。
     *
     * @return 精神科医師存在区分
     */
    public GogitaiSeishinkaIshiSonzaiKubun get精神科医師存在区分() {
        return 合議体精神科医師存在区分;
    }

    /**
     * 精神科医が存在するか否かを返します。
     *
     * @return 存在するならtrue
     */
    public boolean is精神科医存在() {
        return 合議体精神科医師存在区分 == GogitaiSeishinkaIshiSonzaiKubun.存在;
    }

    /**
     * ダミー区分を返します。
     *
     * @return ダミー区分
     */
    public GogitaiDummyKubun getダミー区分() {
        return 合議体ダミー区分;
    }

    /**
     * ダミーであるか否かを返します。
     *
     * @return ダミーならtrue
     */
    public boolean isDummy() {
        return 合議体ダミー区分 == GogitaiDummyKubun.ダミー;
    }

    /**
     * 審査会資料作成年月日を返します。
     *
     * @return 審査会資料作成年月日
     */
    public FlexibleDate get審査会資料作成年月日() {
        return 審査会資料作成年月日;
    }

    /**
     * 休会区分を返します。
     *
     * @return 休会区分
     */
    public ShinsakaiKyukaiKubun get休会区分() {
        return 審査会休会区分;
    }

    /**
     * 審査会が休会であるか否かを返します。
     *
     * @return 休会ならtrue
     */
    public boolean is休会() {
        return 審査会休会区分 == ShinsakaiKyukaiKubun.休会;
    }

    /**
     * 審査会割当済み人数を返します。
     *
     * @return 審査会割当済み人数
     */
    public int get審査会割当済み人数() {
        return 審査会割当済み人数;
    }

    /**
     * 資料作成区分を返します。
     *
     * @return 資料作成区分
     */
    public Code get資料作成区分() {
        return 資料作成区分;
    }

    @Override
    public int hashCode() {
        int hash = 7
                + 29 * Objects.hashCode(this.審査会開催番号)
                + 29 * Objects.hashCode(this.審査会開催年月日)
                + 29 * Objects.hashCode(this.審査会開始時間)
                + 29 * Objects.hashCode(this.審査会終了時間)
                + 29 * Objects.hashCode(this.合議体情報)
                + 29 * this.審査会予定定員
                + 29 * this.審査会最大定員
                + 29 * this.審査会自動割当定員
                + 29 * this.審査会委員定員
                + 29 * Objects.hashCode(this.合議体精神科医師存在区分)
                + 29 * Objects.hashCode(this.合議体ダミー区分)
                + 29 * Objects.hashCode(this.審査会資料作成年月日)
                + 29 * Objects.hashCode(this.審査会休会区分)
                + 29 * this.審査会割当済み人数
                + 29 * Objects.hashCode(this.資料作成区分);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShinsakaiDetail other = (ShinsakaiDetail) obj;
        if (!Objects.equals(this.審査会開催番号, other.審査会開催番号)) {
            return false;
        }
        if (!Objects.equals(this.審査会開催年月日, other.審査会開催年月日)) {
            return false;
        }
        if (!Objects.equals(this.審査会開始時間, other.審査会開始時間)) {
            return false;
        }
        if (!Objects.equals(this.審査会終了時間, other.審査会終了時間)) {
            return false;
        }
        if (!Objects.equals(this.合議体情報, other.合議体情報)) {
            return false;
        }
        if (!Objects.equals(this.審査会開催場所, other.審査会開催場所)) {
            return false;
        }
        if (this.審査会予定定員 != other.審査会予定定員) {
            return false;
        }
        if (this.審査会最大定員 != other.審査会最大定員) {
            return false;
        }
        if (this.審査会自動割当定員 != other.審査会自動割当定員) {
            return false;
        }
        if (this.審査会委員定員 != other.審査会委員定員) {
            return false;
        }
        if (this.合議体精神科医師存在区分 != other.合議体精神科医師存在区分) {
            return false;
        }
        if (this.合議体ダミー区分 != other.合議体ダミー区分) {
            return false;
        }
        if (!Objects.equals(this.審査会資料作成年月日, other.審査会資料作成年月日)) {
            return false;
        }
        if (this.審査会休会区分 != other.審査会休会区分) {
            return false;
        }
        if (this.審査会割当済み人数 != other.審査会割当済み人数) {
            return false;
        }
        if (!Objects.equals(this.資料作成区分, other.資料作成区分)) {
            return false;
        }
        return true;
    }

    /**
     * 審査会情報を作成するための内部クラスです。
     */
    public static class Builder {

        private final ShinsakaiKaisaiNo shinsakaiKaisaiNo;
        private final FlexibleDate kaisaiDate;
        private final TimeString kaishiTime;
        private final TimeString shuryoTime;
        private final GogitaiDetail gogitaiDetail;
        private ShinsakaiKaisaiBasho kaisaiBasho;
        private int plannedTeiin;
        private int maxTeiin;
        private int autoWariateTeiin;
        private int memberTeiin;
        private GogitaiSeishinkaIshiSonzaiKubun existSeishinkaIshi;
        private GogitaiDummyKubun gogitaiDummyKubun;
        private FlexibleDate documentationDate;
        private ShinsakaiKyukaiKubun kyukaiKubun;
        private int wariatesumi;
        private Code shiryoSakuseiKubun;
        private static final RString エラーメッセージ_0以上 = new RString("0以下");

        /**
         * 必須項目であり、かつ初期値が存在しない項目について値を指定し、審査会のBuilderインスタンスを生成して返します。<br/>
         * その他の項目については初期値が設定されます。合議体に存在する項目については、合議体の情報を元に初期値を設定します。<br/>
         * 必須項目にnullが渡された場合、NullPointerExceptionが発生します。
         *
         * @param 審査会開催番号 審査会開催番号
         * @param 審査会開催年月日 審査会開催年月日
         * @param 審査会開始時間 審査会開始時間
         * @param 審査会終了時間 審査会終了時間
         * @param 合議体情報 合議体情報
         * @throws NullPointerException 引数のいずれかにnullが渡されたとき
         */
        public Builder(ShinsakaiKaisaiNo 審査会開催番号, FlexibleDate 審査会開催年月日, TimeString 審査会開始時間,
                TimeString 審査会終了時間, GogitaiDetail 合議体情報) throws NullPointerException {

            RString null例外表示 = new RString("審査会情報");
            requireNonNull(審査会開催番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("審査会開催番号", null例外表示.toString()));
            requireNonNull(審査会開催年月日, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("審査会開催年月日", null例外表示.toString()));
            requireNonNull(審査会開始時間, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("審査会開始時間", null例外表示.toString()));
            requireNonNull(審査会終了時間, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("審査会終了時間", null例外表示.toString()));
            requireNonNull(合議体情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("合議体情報", null例外表示.toString()));

            this.shinsakaiKaisaiNo = 審査会開催番号;
            this.kaisaiDate = 審査会開催年月日;
            this.kaishiTime = 審査会開始時間;
            this.shuryoTime = 審査会終了時間;
            this.gogitaiDetail = 合議体情報;

            this.kaisaiBasho = 合議体情報.get審査会開催場所();
            this.plannedTeiin = 合議体情報.get審査会予定定員();
            this.maxTeiin = 合議体情報.get審査会予定定員();
            this.autoWariateTeiin = 合議体情報.get審査会自動割当定員();
            this.memberTeiin = 合議体情報.get審査会委員定員();
            this.existSeishinkaIshi = 合議体情報.get精神科医師存在();
            this.gogitaiDummyKubun = 合議体情報.getダミー区分();

            this.documentationDate = FlexibleDate.MIN;
            this.kyukaiKubun = ShinsakaiKyukaiKubun.開催;
            this.wariatesumi = 0;
            this.shiryoSakuseiKubun = new Code(new RString("0"));
        }

        /**
         * Builderで設定した情報を元に、審査会情報を生成して返します。<br/>
         * 生成と同時に、定員などの数値が正しく設定されているかのチェックも行います。
         *
         * @return 審査会情報
         */
        public ShinsakaiDetail build() {
            return new ShinsakaiDetail(this);
        }

        /**
         * 審査会開催場所の情報を設定して、自身を返します。
         *
         * @param 審査会開催場所 審査会開催場所
         * @return 審査会情報Builder
         * @throws NullPointerException 審査会開催場所にnullが設定された場合
         */
        public Builder set審査会開催場所(ShinsakaiKaisaiBasho 審査会開催場所) throws NullPointerException {
            requireNonNull(審査会開催場所, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会開催場所"));
            kaisaiBasho = 審査会開催場所;
            return this;
        }

        /**
         * 審査会予定定員を設定して、自身を返します。
         *
         * @param 審査会予定定員 審査会予定定員
         * @return 審査会情報Builder
         * @throws IllegalArgumentException 審査会予定定員に0より小さい値が渡されたとき
         */
        public Builder set審査会予定定員(int 審査会予定定員) throws IllegalArgumentException {
            check0以上(審査会予定定員, UrErrorMessages.項目に対する制約.getMessage().replace("審査会予定定員", エラーメッセージ_0以上.toString()).evaluate());
            plannedTeiin = 審査会予定定員;
            return this;
        }

        private int check0以上(int check対象, String エラー表示) {
            if (check対象 < 0) {
                throw new IllegalArgumentException(エラー表示);
            }
            return check対象;
        }

        /**
         * 審査会最大定員を設定して、自身を返します。
         *
         * @param 審査会最大定員 審査会最大定員
         * @return 審査会情報Builder
         * @throws IllegalArgumentException 審査会最大定員に0より小さい値が渡されたとき
         */
        public Builder set審査会最大定員(int 審査会最大定員) throws IllegalArgumentException {
            check0以上(審査会最大定員, UrErrorMessages.項目に対する制約.getMessage().replace("審査会最大定員", エラーメッセージ_0以上.toString()).evaluate());
            maxTeiin = 審査会最大定員;
            return this;
        }

        /**
         * 審査会自動割当定員の情報を設定して、自身を返します。
         *
         * @param 審査会自動割当定員 審査会自動割当定員
         * @return 審査会情報Builder
         * @throws IllegalArgumentException 審査会自動割当定員に0より小さい値が渡されたとき
         */
        public Builder set審査会自動割当定員(int 審査会自動割当定員) throws IllegalArgumentException {
            check0以上(審査会自動割当定員, UrErrorMessages.項目に対する制約.getMessage().replace("審査会自動割当定員", エラーメッセージ_0以上.toString()).evaluate());
            autoWariateTeiin = 審査会自動割当定員;
            return this;
        }

        /**
         * 審査会委員定員を設定して、自身を返します。
         *
         * @param 審査会委員定員 審査会委員定員
         * @return 審査会情報Builder
         * @throws IllegalArgumentException 審査会委員定員に0より小さい値が渡されたとき
         */
        public Builder set審査会委員定員(int 審査会委員定員) throws IllegalArgumentException {
            check0以上(審査会委員定員, UrErrorMessages.項目に対する制約.getMessage().replace("審査会委員定員", エラーメッセージ_0以上.toString()).evaluate());
            memberTeiin = 審査会委員定員;
            return this;
        }

        /**
         * 合議体精神科医存在区分を設定して、自身を返します。
         *
         * @param 合議体精神科医存在区分 合議体精神科医存在区分
         * @return 審査会情報Builder
         */
        public Builder set精神科医存在区分(GogitaiSeishinkaIshiSonzaiKubun 合議体精神科医存在区分) {
            existSeishinkaIshi = 合議体精神科医存在区分;
            return this;
        }

        /**
         * 合議体ダミー区分を設定して、自身を返します。
         *
         * @param 合議体ダミー区分 合議体ダミー区分
         * @return 審査会情報Builder
         */
        public Builder set合議体ダミー区分(GogitaiDummyKubun 合議体ダミー区分) {
            gogitaiDummyKubun = 合議体ダミー区分;
            return this;
        }

        /**
         * 審査会資料作成年月日を設定して、自身を返します。
         *
         * @param 審査会資料作成年月日 審査会資料作成年月日
         * @return 審査会情報Builder
         */
        public Builder set審査会資料作成年月日(FlexibleDate 審査会資料作成年月日) {
            documentationDate = 審査会資料作成年月日;
            return this;
        }

        /**
         * 審査会休会区分を設定して、自身を返します。
         *
         * @param 審査会休会区分 審査会休会区分
         * @return 審査会情報Builder
         */
        public Builder set審査会休会区分(ShinsakaiKyukaiKubun 審査会休会区分) {
            kyukaiKubun = 審査会休会区分;
            return this;
        }

        /**
         * 審査会割当済み人数を設定して、自身を返します。
         *
         * @param 審査会割当済み人数 審査会割当済み人数
         * @return 審査会情報Builder
         * @throws IllegalArgumentException 審査会割当済み人数に0より小さい値が渡されたとき
         */
        public Builder set審査会割当済み人数(int 審査会割当済み人数) throws IllegalArgumentException {
            check0以上(審査会割当済み人数, UrErrorMessages.項目に対する制約.getMessage().replace("審査会割当済み人数", エラーメッセージ_0以上.toString()).evaluate());
            wariatesumi = 審査会割当済み人数;
            return this;
        }

        /**
         * 資料作成区分を設定して、自身を返します。
         *
         * @param 資料作成区分 資料作成区分
         * @return 審査会情報Builder
         */
        public Builder set資料作成区分(Code 資料作成区分) {
            shiryoSakuseiKubun = 資料作成区分;
            return this;
        }
    }
}
