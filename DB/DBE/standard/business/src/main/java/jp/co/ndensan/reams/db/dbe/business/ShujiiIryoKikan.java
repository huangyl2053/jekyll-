/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 主治医医療機関を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShujiiIryoKikan implements IShujiiIryoKikan {

    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final KaigoIryoKikanCode 介護医療機関コード;
    private final IIryoKikanCode 医療機関コード;
    private final IryoKikanJokyo 医療機関の状況;
    private final IryoKikanKubun 医療機関の区分;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 介護医療機関コード 介護医療機関コード
     * @param 医療機関コード 医療機関コード
     * @param 医療機関の状況 医療機関の状況
     * @param 医療機関の区分 医療機関の区分
     * @throws NullPointerException
     * 証記載保険者番号、介護医療機関コード、医療機関コード、医療機関状況にNULLが渡された場合
     */
    public ShujiiIryoKikan(ShoKisaiHokenshaNo 証記載保険者番号, KaigoIryoKikanCode 介護医療機関コード,
            IIryoKikanCode 医療機関コード, IryoKikanJokyo 医療機関の状況, IryoKikanKubun 医療機関の区分) throws NullPointerException {
        requireNonNull(証記載保険者番号, Messages.E00003.replace("証記載保険者番号", getClass().getName()).getMessage());
        requireNonNull(介護医療機関コード, Messages.E00003.replace("介護医療機関コード", getClass().getName()).getMessage());
        requireNonNull(医療機関コード, Messages.E00003.replace("get医療機関コード", getClass().getName()).getMessage());
        requireNonNull(医療機関の状況, Messages.E00003.replace("医療機関の状況", getClass().getName()).getMessage());

        this.証記載保険者番号 = 証記載保険者番号;
        this.介護医療機関コード = 介護医療機関コード;
        this.医療機関コード = 医療機関コード;
        this.医療機関の状況 = 医療機関の状況;
        this.医療機関の区分 = 医療機関の区分;
    }

    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return 証記載保険者番号;
    }

    @Override
    public KaigoIryoKikanCode get介護医療機関コード() {
        return 介護医療機関コード;
    }

    @Override
    public IIryoKikanCode get医療機関コード() {
        return 医療機関コード;
    }

    @Override
    public boolean is有効() {
        return 医療機関の状況.is有効();
    }

    @Override
    public IryoKikanKubun get医療機関区分() {
        return 医療機関の区分;
    }

    @Override
    public IryoKikanJokyo get医療機関状況() {
        return 医療機関の状況;
    }
}
