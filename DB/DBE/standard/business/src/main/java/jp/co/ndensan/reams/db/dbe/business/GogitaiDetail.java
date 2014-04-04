/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体の詳細な情報を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiDetail {

    private final GogitaiNo 合議体番号;
    private final RString 合議体名称;
    private final GogitaiYukoKikanKaishiYMD 有効期間開始年月日;
    private final FlexibleDate 有効期間終了年月日;
    private final Range<TimeString> 予定開催時間;
    private final ShinsakaiKaisaiBasho 審査会開催場所;
    private final int 審査会予定定員;
    private final int 審査会自動割当定員;
    private final int 審査会委員定員;
    private final GogitaiSeishinkaIshiSonzaiKubun 精神科医師存在区分;
    private final GogitaiDummyKubun ダミー区分;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体名称 合議体名称
     * @param 有効期間開始年月日 有効期間開始年月日
     * @param 有効期間終了年月日 有効期間終了年月日
     * @param 予定開催時間 予定開催時間
     * @param 審査会開催場所 審査会開催場所
     * @param 審査会予定定員 審査会予定定員
     * @param 審査会自動割当定員 審査会自動割当定員
     * @param 審査会委員定員 審査会委員定員
     * @param 精神科医師存在区分 精神科医師存在区分
     * @param ダミー区分 ダミー区分
     * @throws NullPointerException
     * 合議体番号、合議体名称、有効期間、開始終了予定時刻、審査会開催場所のいずれかにnullが渡されたとき
     * @throws IllegalArgumentException
     * 審査会予定定員、審査会自動割当定員、審査会委員定員のいずれかに0より小さい値が渡されたとき
     */
    public GogitaiDetail(GogitaiNo 合議体番号, RString 合議体名称, GogitaiYukoKikanKaishiYMD 有効期間開始年月日,
            FlexibleDate 有効期間終了年月日, Range<TimeString> 予定開催時間, ShinsakaiKaisaiBasho 審査会開催場所,
            int 審査会予定定員, int 審査会自動割当定員, int 審査会委員定員,
            GogitaiSeishinkaIshiSonzaiKubun 精神科医師存在区分, GogitaiDummyKubun ダミー区分)
            throws NullPointerException, IllegalArgumentException {
        requireNonNull(合議体番号, Messages.E00003.replace("合議体番号", getClass().getName()).getMessage());
        requireNonNull(合議体名称, Messages.E00003.replace("合議体名称", getClass().getName()).getMessage());
        requireNonNull(有効期間開始年月日, Messages.E00003.replace("有効期間開始年月日", getClass().getName()).getMessage());
        requireNonNull(有効期間終了年月日, Messages.E00003.replace("有効期間終了年月日", getClass().getName()).getMessage());
        requireNonNull(予定開催時間, Messages.E00003.replace("予定開催時間", getClass().getName()).getMessage());
        requireNonNull(審査会開催場所, Messages.E00003.replace("審査会開催場所", getClass().getName()).getMessage());

        checkゼロ以下(審査会予定定員, Messages.E00013.replace("審査会予定定員", "0以上").getMessage());
        checkゼロ以下(審査会自動割当定員, Messages.E00013.replace("審査会自動割当定員", "0以上").getMessage());
        checkゼロ以下(審査会委員定員, Messages.E00013.replace("審査会委員定員", "0以上").getMessage());

        this.合議体番号 = 合議体番号;
        this.合議体名称 = 合議体名称;
        this.有効期間開始年月日 = 有効期間開始年月日;
        this.有効期間終了年月日 = 有効期間終了年月日;
        this.予定開催時間 = 予定開催時間;
        this.審査会開催場所 = 審査会開催場所;
        this.審査会予定定員 = 審査会予定定員;
        this.審査会自動割当定員 = 審査会自動割当定員;
        this.審査会委員定員 = 審査会委員定員;
        this.精神科医師存在区分 = 精神科医師存在区分;
        this.ダミー区分 = ダミー区分;
    }

    private int checkゼロ以下(int check対象, String message) throws IllegalArgumentException {
        if (check対象 < 0) {
            throw new IllegalArgumentException(message);
        }
        return check対象;
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public GogitaiNo get合議体番号() {
        return 合議体番号;
    }

    /**
     * 合議体の名称を返します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return 合議体名称;
    }

    /**
     * 有効期間開始年月日を返します。
     *
     * @return 有効期間開始年月日
     */
    public GogitaiYukoKikanKaishiYMD get有効期間開始年月日() {
        return 有効期間開始年月日;
    }

    /**
     * 有効期間終了年月日を返します。
     *
     * @return 有効期間終了年月日
     */
    public FlexibleDate get有効期間終了年月日() {
        return 有効期間終了年月日;
    }

    /**
     * 予定されている開催時間を返します。
     *
     * @return 予定開催時間
     */
    public Range<TimeString> get予定開催時間() {
        return 予定開催時間;
    }

    /**
     * 開始予定時刻を取得します。
     *
     * @return 開始予定時刻
     */
    public TimeString get開始予定時刻() {
        return 予定開催時間.getFrom();
    }

    /**
     * 終了予定時刻を取得します。
     *
     * @return 終了予定時刻
     */
    public TimeString get終了予定時刻() {
        return 予定開催時間.getTo();
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
     * 審査会自動割当定員を返します。
     *
     * @return 審査会自動割当定員
     */
    public int get審査会自動割当定員() {
        return 審査会自動割当定員;
    }

    /**
     * 審査会委員の定員を返します。
     *
     * @return 審査会委員定員
     */
    public int get審査会委員定員() {
        return 審査会委員定員;
    }

    /**
     * 合議体に精神科医が存在するか否かを示す要素を返します。
     *
     * @return 精神科医師存在
     */
    public GogitaiSeishinkaIshiSonzaiKubun get精神科医師存在() {
        return 精神科医師存在区分;
    }

    /**
     * 合議体がダミーであるか否かを表す要素を返します。
     *
     * @return ダミー区分
     */
    public GogitaiDummyKubun getダミー区分() {
        return ダミー区分;
    }

    /**
     * 合議体に精神科医が参加しているかどうかを返します。
     *
     * @return 精神科医が存在するならtrue
     */
    public boolean has精神科医() {
        return 精神科医師存在区分.is存在();
    }

    /**
     * 合議体がダミーであるか否かを返します。
     *
     * @return ダミーならtrue
     */
    public boolean isDummy() {
        return ダミー区分.isダミー();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * (hash + Objects.hashCode(this.合議体番号)
                + Objects.hashCode(this.合議体名称)
                + Objects.hashCode(this.有効期間開始年月日)
                + Objects.hashCode(this.有効期間終了年月日)
                + Objects.hashCode(this.予定開催時間.getFrom())
                + Objects.hashCode(this.予定開催時間.getTo())
                + Objects.hashCode(this.審査会開催場所.get開催場所コード())
                + this.審査会予定定員
                + this.審査会自動割当定員
                + this.審査会委員定員
                + Objects.hashCode(this.精神科医師存在区分)
                + Objects.hashCode(this.ダミー区分));
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || (getClass() != 比較対象.getClass())) {
            return false;
        }

        final GogitaiDetail other = (GogitaiDetail) 比較対象;
        if (!Objects.equals(this.get合議体番号(), other.get合議体番号())) {
            return false;
        }
        if (!Objects.equals(this.get有効期間開始年月日(), other.get有効期間開始年月日())) {
            return false;
        }
        if (!Objects.equals(this.get合議体名称(), other.get合議体名称())) {
            return false;
        }
        if (!Objects.equals(this.get有効期間終了年月日(), other.get有効期間終了年月日())) {
            return false;
        }
        if (!Objects.equals(this.get開始予定時刻(), other.get開始予定時刻())) {
            return false;
        }
        if (!Objects.equals(this.get終了予定時刻(), other.get終了予定時刻())) {
            return false;
        }
        if (!Objects.equals(this.get審査会開催場所().get開催場所コード(), other.get審査会開催場所().get開催場所コード())) {
            return false;
        }
        if (!Objects.equals(this.get審査会予定定員(), other.get審査会予定定員())) {
            return false;
        }
        if (!Objects.equals(this.get審査会自動割当定員(), other.get審査会自動割当定員())) {
            return false;
        }
        if (!Objects.equals(this.get審査会委員定員(), other.get審査会委員定員())) {
            return false;
        }
        if (!Objects.equals(this.get精神科医師存在(), other.get精神科医師存在())) {
            return false;
        }
        if (!Objects.equals(this.getダミー区分(), other.getダミー区分())) {
            return false;
        }

        return true;
    }
}
