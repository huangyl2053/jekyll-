/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ShujiiIryoKikan;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.core.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.IryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigoiryokikancode.KaigoIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 主治医医療機関を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShujiiIryoKikan implements IShujiiIryoKikan {

    private final LasdecCode 市町村コード;
    private final KaigoIryoKikanCode 介護医療機関コード;
    private final IryoKikanCode 医療機関コード;
    private final IryoKikanJokyo 医療機関の状況;
    private final IryoKikanKubun 医療機関の区分;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @param 医療機関コード 医療機関コード
     * @param 医療機関の状況 医療機関の状況
     * @param 医療機関の区分 医療機関の区分
     * @throws NullPointerException 市町村コード、介護医療機関コード、医療機関コード、医療機関状況にNULLが渡された場合
     */
    public ShujiiIryoKikan(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード,
            IryoKikanCode 医療機関コード, IryoKikanJokyo 医療機関の状況, IryoKikanKubun 医療機関の区分) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("市町村コード", getClass().getName()));
        requireNonNull(介護医療機関コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("介護医療機関コード", getClass().getName()));
        requireNonNull(医療機関コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("get医療機関コード", getClass().getName()));
        requireNonNull(医療機関の状況, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("医療機関の状況", getClass().getName()));

        this.市町村コード = 市町村コード;
        this.介護医療機関コード = 介護医療機関コード;
        this.医療機関コード = 医療機関コード;
        this.医療機関の状況 = 医療機関の状況;
        this.医療機関の区分 = 医療機関の区分;
    }

    @Override
    public LasdecCode get市町村コード() {
        return 市町村コード;
    }

    @Override
    public KaigoIryoKikanCode get介護医療機関コード() {
        return 介護医療機関コード;
    }

    @Override
    public IryoKikanCode get医療機関コード() {
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
