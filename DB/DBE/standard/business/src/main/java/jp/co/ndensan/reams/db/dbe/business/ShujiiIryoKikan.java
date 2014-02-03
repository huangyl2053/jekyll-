/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 主治医医療機関を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShujiiIryoKikan implements IShujiiIryoKikan {

    private final ShichosonCode 市町村コード;
    private final KaigoIryoKikanCode 介護医療機関コード;
    private final IIryoKikanCode get医療機関コード;
    private final IryoKikanJokyo 医療機関の状況;
    private final IryoKikanKubun 医療機関の区分;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @param get医療機関コード get医療機関コード
     * @param 医療機関の状況 医療機関の状況
     * @param 医療機関の区分 医療機関の区分
     */
    public ShujiiIryoKikan(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, IIryoKikanCode get医療機関コード, IryoKikanJokyo 医療機関の状況, IryoKikanKubun 医療機関の区分) {
        requireNonNull(市町村コード, Messages.E00003.replace("市町村コード", getClass().getName()).getMessage());
        requireNonNull(介護医療機関コード, Messages.E00003.replace("介護医療機関コード", getClass().getName()).getMessage());
        requireNonNull(get医療機関コード, Messages.E00003.replace("get医療機関コード", getClass().getName()).getMessage());
        requireNonNull(医療機関の状況, Messages.E00003.replace("医療機関の状況", getClass().getName()).getMessage());

        this.市町村コード = 市町村コード;
        this.介護医療機関コード = 介護医療機関コード;
        this.get医療機関コード = get医療機関コード;
        this.医療機関の状況 = 医療機関の状況;
        this.医療機関の区分 = 医療機関の区分;
    }

    @Override
    public ShichosonCode get市町村コード() {
        return 市町村コード;
    }

    @Override
    public KaigoIryoKikanCode get介護医療機関コード() {
        return 介護医療機関コード;
    }

    @Override
    public IIryoKikanCode get医療機関コード() {
        return get医療機関コード;
    }

    @Override
    public boolean is有効() {
        return 医療機関の状況.is有効();
    }

    @Override
    public IryoKikanKubun get医療機関区分() {
        return 医療機関の区分;
    }
}
