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
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiDate;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaishiTime;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会の詳細な情報を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiDetail {

    private final ShinsakaiKaisaiNo 審査会開催番号;
    private final ShinsakaiKaisaiDate 審査会開催年月日;
    private final ShinsakaiKaishiTime 審査会開始時間;
    private final TimeString 審査会終了時間;
    private final GogitaiDetail 合議体情報;
    private final ShinsakaiKaisaiBasho 開催場所;
    private final int 審査会予定定員;
    private final int 審査会最大定員;
    private final int 審査会自動割当定員;
    private final int 審査会委員定員;
    private final GogitaiSeishinkaIshiSonzaiKubun 精神科医師存在区分;
    private final GogitaiDummyKubun ダミー区分;
    private final FlexibleDate 審査会資料作成年月日;
    private final ShinsakaiKyukaiKubun 休会区分;
    private final int 審査会割当済み人数;

    /**
     * 引数から審査会の詳細な情報を受け取り、インスタンスを生成します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 審査会開催年月日 審査会開催年月日
     * @param 審査会開始時間 審査会開始時間
     * @param 審査会終了時間 審査会終了時間
     * @param 合議体情報 合議体情報
     * @param 開催場所 開催場所
     * @param 審査会予定定員 審査会予定定員
     * @param 審査会最大定員 審査会最大定員
     * @param 審査会自動割当定員 審査会自動割当定員
     * @param 審査会委員定員 審査会委員定員
     * @param 精神科医師存在区分 精神科医師存在区分
     * @param ダミー区分 ダミー区分
     * @param 審査会資料作成年月日 審査会資料作成年月日
     * @param 休会区分 休会区分
     * @param 審査会割当済み人数 審査会割当済み人数
     * @throws NullPointerException
     * 審査会開催番号、審査会開催年月日、審査会開始時間、審査会終了時間、合議体情報のいずれかにnullが渡されたとき
     * @throws IllegalArgumentException
     * 審査会予定定員、審査会最大定員、審査会自動割当定員、審査会委員定員、審査会割当済み人数に0より小さい数字が渡されたとき
     */
    public ShinsakaiDetail(ShinsakaiKaisaiNo 審査会開催番号, ShinsakaiKaisaiDate 審査会開催年月日,
            ShinsakaiKaishiTime 審査会開始時間, TimeString 審査会終了時間, GogitaiDetail 合議体情報, ShinsakaiKaisaiBasho 開催場所,
            int 審査会予定定員, int 審査会最大定員, int 審査会自動割当定員, int 審査会委員定員,
            GogitaiSeishinkaIshiSonzaiKubun 精神科医師存在区分, GogitaiDummyKubun ダミー区分, FlexibleDate 審査会資料作成年月日,
            ShinsakaiKyukaiKubun 休会区分, int 審査会割当済み人数) throws NullPointerException, IllegalArgumentException {
        requireNonNull(審査会開催番号, Messages.E00003.replace("審査会開催番号", getClass().getName()).getMessage());
        requireNonNull(審査会開催年月日, Messages.E00003.replace("審査会開催年月日", getClass().getName()).getMessage());
        requireNonNull(審査会開始時間, Messages.E00003.replace("審査会開始時間", getClass().getName()).getMessage());
        requireNonNull(審査会終了時間, Messages.E00003.replace("審査会終了時間", getClass().getName()).getMessage());
        requireNonNull(合議体情報, Messages.E00003.replace("合議体情報", getClass().getName()).getMessage());
        requireNonNull(開催場所, Messages.E00003.replace("開催場所", getClass().getName()).getMessage());

        RString エラー表示 = new RString("0以上");
        check0以上(審査会予定定員, Messages.E00013.replace("審査会予定定員", エラー表示.toString()).getMessage());
        check0以上(審査会最大定員, Messages.E00013.replace("審査会最大定員", エラー表示.toString()).getMessage());
        check0以上(審査会自動割当定員, Messages.E00013.replace("審査会自動割当定員", エラー表示.toString()).getMessage());
        check0以上(審査会委員定員, Messages.E00013.replace("審査会委員定員", エラー表示.toString()).getMessage());
        check0以上(審査会割当済み人数, Messages.E00013.replace("審査会割当済み人数", エラー表示.toString()).getMessage());

        this.審査会開催番号 = 審査会開催番号;
        this.審査会開催年月日 = 審査会開催年月日;
        this.審査会開始時間 = 審査会開始時間;
        this.審査会終了時間 = 審査会終了時間;
        this.合議体情報 = 合議体情報;
        this.開催場所 = 開催場所;
        this.審査会予定定員 = 審査会予定定員;
        this.審査会最大定員 = 審査会最大定員;
        this.審査会自動割当定員 = 審査会自動割当定員;
        this.審査会委員定員 = 審査会委員定員;
        this.精神科医師存在区分 = 精神科医師存在区分;
        this.ダミー区分 = ダミー区分;
        this.審査会資料作成年月日 = 審査会資料作成年月日;
        this.休会区分 = 休会区分;
        this.審査会割当済み人数 = 審査会割当済み人数;
    }

    private int check0以上(int check対象, String エラー表示) {
        if (check対象 < 0) {
            throw new IllegalArgumentException(エラー表示);
        }
        return check対象;
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
    public ShinsakaiKaisaiDate get審査会開催年月日() {
        return 審査会開催年月日;
    }

    /**
     * 審査会開始時間を返します。
     *
     * @return 審査会開始時間
     */
    public ShinsakaiKaishiTime get審査会開始時間() {
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
     * 審査会の開催場所を返します。
     *
     * @return 開催場所
     */
    public ShinsakaiKaisaiBasho get開催場所() {
        return 開催場所;
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
        return 精神科医師存在区分;
    }

    /**
     * 精神科医が存在するか否かを返します。
     *
     * @return 存在するならtrue
     */
    public boolean is精神科医存在() {
        return 精神科医師存在区分 == GogitaiSeishinkaIshiSonzaiKubun.存在;
    }

    /**
     * ダミー区分を返します。
     *
     * @return ダミー区分
     */
    public GogitaiDummyKubun getダミー区分() {
        return ダミー区分;
    }

    /**
     * ダミーであるか否かを返します。
     *
     * @return ダミーならtrue
     */
    public boolean isDummy() {
        return ダミー区分 == GogitaiDummyKubun.ダミー;
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
        return 休会区分;
    }

    /**
     * 審査会が休会であるか否かを返します。
     *
     * @return 休会ならtrue
     */
    public boolean is休会() {
        return 休会区分 == ShinsakaiKyukaiKubun.休会;
    }

    /**
     * 審査会割当済み人数を返します。
     *
     * @return 審査会割当済み人数
     */
    public int get審査会割当済み人数() {
        return 審査会割当済み人数;
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
                + 29 * Objects.hashCode(this.精神科医師存在区分)
                + 29 * Objects.hashCode(this.ダミー区分)
                + 29 * Objects.hashCode(this.審査会資料作成年月日)
                + 29 * Objects.hashCode(this.休会区分)
                + 29 * this.審査会割当済み人数;
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
        if (!Objects.equals(this.開催場所, other.開催場所)) {
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
        if (this.精神科医師存在区分 != other.精神科医師存在区分) {
            return false;
        }
        if (this.ダミー区分 != other.ダミー区分) {
            return false;
        }
        if (!Objects.equals(this.審査会資料作成年月日, other.審査会資料作成年月日)) {
            return false;
        }
        if (this.休会区分 != other.休会区分) {
            return false;
        }
        if (this.審査会割当済み人数 != other.審査会割当済み人数) {
            return false;
        }
        return true;
    }
}
