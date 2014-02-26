/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 審査会開催場所を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiKaisaiBasho {
    //TODO n8178 城間篤人 他チケットで実装予定の箇所のため、後に改修が入る可能性があり 2014年3月末

    private final ShinsakaiKaisaiBashoCode 開催場所コード;
    private final RString 開催場所名;
    private final ShinsakaiKaisaiChiku 開催地区;
    private final AtenaJusho 開催場所住所;
    private final TelNo 電話番号;
    private final ShinsakaiKaisaiBashoJokyo 開催場所状況;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 開催場所コード 開催場所コード
     * @param 開催場所名 開催場所名
     * @param 開催地区 開催地区
     * @param 開催場所住所 開催場所住所
     * @param 電話番号 電話番号
     * @param 開催場所状況 開催場所状況
     * @throws NullPointerException 開催場所コード、開催場所名、開催場所状況にnullが渡されたとき
     */
    public ShinsakaiKaisaiBasho(ShinsakaiKaisaiBashoCode 開催場所コード, RString 開催場所名, ShinsakaiKaisaiChiku 開催地区,
            AtenaJusho 開催場所住所, TelNo 電話番号, ShinsakaiKaisaiBashoJokyo 開催場所状況) throws NullPointerException {
        requireNonNull(開催場所コード, Messages.E00003.replace("開催場所コード", getClass().getName()).getMessage());
        requireNonNull(開催場所名, Messages.E00003.replace("開催場所名", getClass().getName()).getMessage());
        requireNonNull(開催場所状況, Messages.E00003.replace("開催場所状況", getClass().getName()).getMessage());

        this.開催場所コード = 開催場所コード;
        this.開催場所名 = 開催場所名;
        this.開催地区 = 開催地区;
        this.開催場所住所 = 開催場所住所;
        this.電話番号 = 電話番号;
        this.開催場所状況 = 開催場所状況;
    }

    /**
     * 開催場所コードを返します。
     *
     * @return 開催場所コード
     */
    public ShinsakaiKaisaiBashoCode get開催場所コード() {
        return 開催場所コード;
    }

    /**
     * 開催場所の名称を返します。
     *
     * @return 開催場所名
     */
    public RString get開催場所名() {
        return 開催場所名;
    }

    /**
     * 開催地区を返します。
     *
     * @return 開催地区
     */
    public ShinsakaiKaisaiChiku get開催地区() {
        return 開催地区;
    }

    /**
     * 開催場所の住所を返します。
     *
     * @return 開催場所住所
     */
    public AtenaJusho get開催場所住所() {
        return 開催場所住所;
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return 電話番号;
    }

    /**
     * 開催場所状況を返します。
     *
     * @return 開催場所状況
     */
    public ShinsakaiKaisaiBashoJokyo get開催場所状況() {
        return 開催場所状況;
    }
}
