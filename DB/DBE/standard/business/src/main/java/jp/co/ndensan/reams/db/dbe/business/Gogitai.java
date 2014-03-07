/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyFlag;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiFlag;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class Gogitai {

    private final GogitaiNo 合議体番号;
    private final RString 合議体名称;
    private final GogitaiYukoKikanKaishiYMD 有効期間開始年月日;
    private final FlexibleDate 有効期間終了年月日;
    private final Range<TimeString> 開始終了予定時刻;
    private final ShinsakaiKaisaiBasho 審査会開催場所;
    private final int 審査会予定定員;
    private final int 審査会自動割当定員;
    private final int 審査会委員定員;
    private final GogitaiWariateIinList 合議体割当審査会委員List;
    private final GogitaiSeishinkaIshiSonzaiFlag 精神科医師存在フラグ;
    private final GogitaiDummyFlag ダミーフラグ;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体名称 合議体名称
     * @param 有効期間 有効期間
     * @param 開始終了予定時刻 開始終了予定時刻
     * @param 審査会開催場所 審査会開催場所
     * @param 審査会予定定員 審査会予定定員
     * @param 審査会自動割当定員 審査会自動割当定員
     * @param 審査会委員定員 審査会委員定員
     * @param 合議体割当審査会委員List 合議体割当審査会委員List
     * @param 精神科医師存在フラグ 精神科医師存在フラグ
     * @param ダミーフラグ ダミーフラグ
     * @throws NullPointerException
     * 合議体番号、合議体名称、有効期間、開始終了予定時刻、審査会開催場所のいずれかにnullが渡されたとき
     */
    public Gogitai(GogitaiNo 合議体番号, RString 合議体名称, GogitaiYukoKikanKaishiYMD 有効期間開始年月日,
            FlexibleDate 有効期間終了年月日, Range<TimeString> 開始終了予定時刻, ShinsakaiKaisaiBasho 審査会開催場所,
            int 審査会予定定員, int 審査会自動割当定員, int 審査会委員定員, GogitaiWariateIinList 合議体割当審査会委員List,
            GogitaiSeishinkaIshiSonzaiFlag 精神科医師存在フラグ, GogitaiDummyFlag ダミーフラグ)
            throws NullPointerException, IllegalArgumentException {
        requireNonNull(合議体番号, Messages.E00003.replace("合議体番号", getClass().getName()).getMessage());
        requireNonNull(合議体名称, Messages.E00003.replace("合議体名称", getClass().getName()).getMessage());
        requireNonNull(有効期間開始年月日, Messages.E00003.replace("有効期間開始年月日", getClass().getName()).getMessage());
        requireNonNull(有効期間終了年月日, Messages.E00003.replace("有効期間終了年月日", getClass().getName()).getMessage());
        requireNonNull(開始終了予定時刻, Messages.E00003.replace("開始終了予定時刻", getClass().getName()).getMessage());
        requireNonNull(審査会開催場所, Messages.E00003.replace("審査会開催場所", getClass().getName()).getMessage());

        if (checkゼロ以下(審査会予定定員, 審査会自動割当定員, 審査会委員定員)) {
            throw new IllegalArgumentException(Messages.E00009.replace("人数を表す項目の内容").getMessage());
        }
        this.合議体番号 = 合議体番号;
        this.合議体名称 = 合議体名称;
        this.有効期間開始年月日 = 有効期間開始年月日;
        this.有効期間終了年月日 = 有効期間終了年月日;
        this.開始終了予定時刻 = 開始終了予定時刻;
        this.審査会開催場所 = 審査会開催場所;
        this.審査会予定定員 = 審査会予定定員;
        this.審査会自動割当定員 = 審査会自動割当定員;
        this.審査会委員定員 = 審査会委員定員;
        this.合議体割当審査会委員List = 合議体割当審査会委員List;
        this.精神科医師存在フラグ = 精神科医師存在フラグ;
        this.ダミーフラグ = ダミーフラグ;
    }

    private boolean checkゼロ以下(int... check対象s) {
        for (int check対象 : check対象s) {
            if (check対象 < 0) {
                return true;
            }
        }
        return false;
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
     * 開始終了予定時刻を返します。
     *
     * @return 開始終了予定時刻
     */
    public Range<TimeString> get開始終了予定時刻() {
        return 開始終了予定時刻;
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
     * 合議体に割り当てられた審査委員会のリストを返します。
     *
     * @return 合議体割当審査会委員List
     */
    public GogitaiWariateIinList get合議体割当審査会委員List() {
        return 合議体割当審査会委員List;
    }

    /**
     * 合議体に精神科医が存在するか否かを示す要素を返します。
     *
     * @return 精神科医師存在
     */
    public GogitaiSeishinkaIshiSonzaiFlag get精神科医師存在() {
        return 精神科医師存在フラグ;
    }

    /**
     * 合議体がダミーであるか否かを表す要素を返します。
     *
     * @return 合議体ダミー
     */
    public GogitaiDummyFlag get合議体ダミー() {
        return ダミーフラグ;
    }

    /**
     * 合議体に精神科医が参加しているかどうかを返します。
     *
     * @return 精神科医が存在するならtrue
     */
    public boolean has精神科医() {
        return 精神科医師存在フラグ.is存在();
    }

    /**
     * 合議体がダミーであるか否かを返します。
     *
     * @return ダミーならtrue
     */
    public boolean isDummy() {
        return ダミーフラグ.isDummy();
    }
}
