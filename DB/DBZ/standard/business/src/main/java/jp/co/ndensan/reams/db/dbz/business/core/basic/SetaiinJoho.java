/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.jukikojin.IJukiKojin;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員情報を管理するクラスです。
 */
public class SetaiinJoho {

    private static final int JUMINHYO_HYOJIJUN_LAST = 99;
    private final IShikibetsuTaisho 識別対象;
    private final RString 本人区分;
    private final IKojin 個人;
    private final IJukiKojin 住基個人;

    /**
     * コンストラクタです。<br/>
     * 世帯員情報の新規作成時に使用します。
     *
     * @param 識別対象 識別対象
     * @param 本人区分 本人区分
     */
    public SetaiinJoho(IShikibetsuTaisho 識別対象, RString 本人区分) {
        requireNonNull(識別対象, UrSystemErrorMessages.値がnull.getReplacedMessage("識別対象"));
        requireNonNull(本人区分, UrSystemErrorMessages.値がnull.getReplacedMessage("本人区分"));
        this.識別対象 = 識別対象;
        this.本人区分 = 本人区分;
        if (!識別対象.canBe個人()) {
            this.個人 = null;
            this.住基個人 = null;
        } else {
            this.個人 = 識別対象.to個人();
            this.住基個人 = this.個人.canBe住基個人() ? this.個人.to住基個人() : null;
        }
    }

    /**
     * 識別対象を返します。
     *
     * @return 識別対象
     */
    public IShikibetsuTaisho get識別対象() {
        return 識別対象;
    }

    /**
     * 本人区分を返します。
     *
     * @return 本人区分
     */
    public RString get本人区分() {
        return 本人区分;
    }

    /**
     * 生年月日を{@link FlexibleDate}型で返却します。
     * <p/>
     * 生年月日が取得できない場合は、{@link FlexibleDate#EMPTY}を返却します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return 個人 == null ? FlexibleDate.EMPTY : 個人.get生年月日().toFlexibleDate();
    }

    /**
     * 性別を返却します。
     *
     * @return 性別
     */
    public Gender get性別() {
        return 個人 == null ? Gender.未定義 : 個人.get性別();
    }

    /**
     * 続柄コードを返します。
     *
     * @return 続柄コード
     */
    public RString get続柄コード() {
        return 個人 == null ? RString.EMPTY : 個人.get続柄コードリスト().toTsuzukigaraCode().value();
    }

    /**
     * 続柄を返します。
     *
     * @return 続柄
     */
    public RString get続柄() {
        return 個人 == null ? RString.EMPTY : 個人.get続柄();
    }

    /**
     * 住民状態を返します。
     *
     * @return 住民状態
     */
    public JuminJotai get住民状態() {
        return 個人 == null ? JuminJotai.未定義 : 個人.get住民状態();
    }

    /**
     * 住定異動年月日を返します。
     *
     * @return 住定異動年月日
     */
    public FlexibleDate get住定異動年月日() {
        return 個人 == null ? FlexibleDate.EMPTY : 個人.get住定異動年月日();
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return 個人 == null ? SetaiCode.EMPTY : 個人.get世帯コード();
    }

    /**
     * 住民票表示順を返します。
     *
     * @return 住民票表示順
     */
    public int get住民票表示順() {
        return 住基個人 == null ? JUMINHYO_HYOJIJUN_LAST : 住基個人.get住民票表示順();
    }

}
