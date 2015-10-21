/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.KaigoIryoKikan;

import jp.co.ndensan.reams.db.dbe.business.core.ShujiiIryoKikan.IShujiiIryoKikan;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.core.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.IryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigoiryokikancode.KaigoIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ux.uxx.business.core.iryokikan.IryoKikan;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護の主治医医療機関を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class KaigoIryoKikan implements IShujiiIryoKikan {

    private final IShujiiIryoKikan 主治医医療機関;
    private final IryoKikan 医療機関;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 医療機関 医療機関
     * @param 主治医医療機関 主治医医療機関
     * @throws NullPointerException 引数にNULLが渡された場合
     */
    public KaigoIryoKikan(IryoKikan 医療機関, IShujiiIryoKikan 主治医医療機関) throws NullPointerException {
        requireNonNull(医療機関, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("医療機関", getClass().getName()));
        requireNonNull(主治医医療機関, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("主治医医療機関", getClass().getName()));

        this.医療機関 = 医療機関;
        this.主治医医療機関 = 主治医医療機関;
    }

    // TODO n8300姜　ビルドエラー回避のために暫定対応
//    @Override
//    public IryoKikanCode get医療機関コード() {
//        return 医療機関.get医療機関コード();
//    }
    /**
     * 医療機関名を返します。
     *
     * @return 医療機関名
     */
    public AtenaMeisho get医療機関名称() {
        return 医療機関.get医療機関名();
    }

    /**
     * 医療機関の略称を返します。
     *
     * @return 医療機関略称
     */
    public RString get医療機関略称() {
        return 医療機関.get医療機関名略称();
    }

    /**
     * 医療機関の郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return 医療機関.get郵便番号();
    }

    /**
     * 医療機関の住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        return 医療機関.get住所();
    }

    public FlexibleDate get開設期間() {
        return 医療機関.get新設年月日();
    }

    public FlexibleDate get異動年月日() {
        return 医療機関.get異動年月日();
    }

    public FlexibleDate get廃止年月日() {
        return 医療機関.get廃止年月日();
    }

    public boolean is休止() {
        return 医療機関.is休止フラグ();
    }

//    public Code get異動事由() {
//        return 医療機関.get異動事由().value();
//    }
//
//    public Code get会員区分() {
//        return 医療機関.get会員区分().value();
//    }
    public boolean is指定自立支援医療機関() {
        return 医療機関.is指定自立支援医療機関フラグ();
    }

    @Override
    public LasdecCode get市町村コード() {
        return 主治医医療機関.get市町村コード();
    }

    @Override
    public KaigoIryoKikanCode get介護医療機関コード() {
        return 主治医医療機関.get介護医療機関コード();
    }

    @Override
    public boolean is有効() {
        return 主治医医療機関.is有効();
    }

    @Override
    public IryoKikanKubun get医療機関区分() {
        return 主治医医療機関.get医療機関区分();
    }

    @Override
    public IryoKikanJokyo get医療機関状況() {
        return 主治医医療機関.get医療機関状況();
    }

    @Override
    public IryoKikanCode get医療機関コード() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
