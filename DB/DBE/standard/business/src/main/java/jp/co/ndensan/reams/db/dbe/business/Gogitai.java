/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummy;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzai;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiMeisho;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static java.util.Objects.requireNonNull;
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
    private final GogitaiMeisho 合議体名称;
    private final Range<FlexibleDate> 有効期間;
    private final Range<RString> 開始終了予定時刻;
    private final ShinsakaiKaisaiBasho 審査会開催場所;
    private final int 審査会予定定員;
    private final int 審査会自動割当定員;
    private final int 審査会委員定員;
    private final GogitaiWariateIinList 合議体割当審査会委員List;
    private final GogitaiSeishinkaIshiSonzai 精神科医師存在;
    private final GogitaiDummy 合議体ダミー;

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
     * @param 精神科医存在 精神科医存在
     * @param 合議体ダミー 合議体ダミー
     * @throws NullPointerException
     * 合議体番号、合議体名称、有効期間、開始終了予定時刻、審査会開催場所のいずれかにnullが渡されたとき
     */
    public Gogitai(GogitaiNo 合議体番号, GogitaiMeisho 合議体名称, Range<FlexibleDate> 有効期間, Range<RString> 開始終了予定時刻,
            ShinsakaiKaisaiBasho 審査会開催場所, int 審査会予定定員, int 審査会自動割当定員, int 審査会委員定員,
            GogitaiWariateIinList 合議体割当審査会委員List, GogitaiSeishinkaIshiSonzai 精神科医存在,
            GogitaiDummy 合議体ダミー) throws NullPointerException {
        requireNonNull(合議体番号, Messages.E00003.replace("合議体番号", getClass().getName()).getMessage());
        requireNonNull(合議体名称, Messages.E00003.replace("合議体名称", getClass().getName()).getMessage());
        requireNonNull(有効期間, Messages.E00003.replace("有効期間", getClass().getName()).getMessage());
        requireNonNull(開始終了予定時刻, Messages.E00003.replace("開始終了予定時刻", getClass().getName()).getMessage());
        requireNonNull(審査会開催場所, Messages.E00003.replace("審査会開催場所", getClass().getName()).getMessage());

        this.合議体番号 = 合議体番号;
        this.合議体名称 = 合議体名称;
        this.有効期間 = 有効期間;
        this.開始終了予定時刻 = 開始終了予定時刻;
        this.審査会開催場所 = 審査会開催場所;
        this.審査会予定定員 = 審査会予定定員;
        this.審査会自動割当定員 = 審査会自動割当定員;
        this.審査会委員定員 = 審査会委員定員;
        this.合議体割当審査会委員List = 合議体割当審査会委員List;
        this.精神科医師存在 = 精神科医存在;
        this.合議体ダミー = 合議体ダミー;
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
    public GogitaiMeisho get合議体名称() {
        return 合議体名称;
    }

    /**
     * 合議体の有効期間を返します。
     *
     * @return 有効期間
     */
    public Range<FlexibleDate> get有効期間() {
        return 有効期間;
    }

    /**
     * 開始終了予定時刻を返します。
     *
     * @return 開始終了予定時刻
     */
    public Range<RString> get開始終了予定時刻() {
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
    public GogitaiSeishinkaIshiSonzai get精神科医師存在() {
        return 精神科医師存在;
    }

    /**
     * 合議体がダミーであるか否かを表す要素を返します。
     *
     * @return 合議体ダミー
     */
    public GogitaiDummy get合議体ダミー() {
        return 合議体ダミー;
    }

    /**
     * 合議体に精神科医が参加しているかどうかを返します。
     *
     * @return 精神科医が存在するならtrue
     */
    public boolean has精神科医存在() {
        return 精神科医師存在.is存在();
    }

    /**
     * 合議体がダミーであるか否かを返します。
     *
     * @return ダミーならtrue
     */
    public boolean isDummy() {
        return 合議体ダミー.isダミー();
    }
}
