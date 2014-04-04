/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IDoctors;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikan;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 介護の主治医医療機関を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class KaigoIryoKikan implements IIryoKikan, IShujiiIryoKikan {

    private IShujiiIryoKikan 主治医医療機関;
    private IIryoKikan 医療機関;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 医療機関 医療機関
     * @param 主治医医療機関 主治医医療機関
     * @throws NullPointerException 引数にNULLが渡された場合
     */
    public KaigoIryoKikan(IIryoKikan 医療機関, IShujiiIryoKikan 主治医医療機関) throws NullPointerException {
        requireNonNull(医療機関, Messages.E00003.replace("医療機関", getClass().getName()).getMessage());
        requireNonNull(主治医医療機関, Messages.E00003.replace("主治医医療機関", getClass().getName()).getMessage());

        this.医療機関 = 医療機関;
        this.主治医医療機関 = 主治医医療機関;
    }

    @Override
    public IIryoKikanCode get医療機関コード() {
        return 医療機関.get医療機関コード();
    }

    @Override
    public ShikibetsuCode get識別コード() {
        return 医療機関.get識別コード();
    }

    @Override
    public IName get医療機関名称() {
        return 医療機関.get医療機関名称();
    }

    @Override
    public IName get医療機関略称() {
        return 医療機関.get医療機関略称();
    }

    @Override
    public RString get所在地郵便番号() {
        return 医療機関.get所在地郵便番号();
    }

    @Override
    public RString get所在地住所() {
        return 医療機関.get所在地住所();
    }

    @Override
    public RString get所在地カナ住所() {
        return 医療機関.get所在地カナ住所();
    }

    @Override
    public Range<FlexibleDate> get開設期間() {
        return 医療機関.get開設期間();
    }

    @Override
    public IDoctors get所属医師() {
        return 医療機関.get所属医師();
    }

    @Override
    public List<IKoza> get口座() {
        return 医療機関.get口座();
    }

    @Override
    public FlexibleDate get異動年月日() {
        return 医療機関.get異動年月日();
    }

    @Override
    public RString get休止区分() {
        return 医療機関.get休止区分();
    }

    @Override
    public RString get異動事由() {
        return 医療機関.get異動事由();
    }

    @Override
    public RString get会員区分() {
        return 医療機関.get会員区分();
    }

    @Override
    public RString get点数表() {
        return 医療機関.get点数表();
    }

    @Override
    public boolean is有効医療機関(FlexibleDate 基準日) {
        return 医療機関.is有効医療機関(基準日);
    }

    @Override
    public boolean is指定自立支援医療機関() {
        return 医療機関.is指定自立支援医療機関();
    }

    @Override
    public ShichosonCode get市町村コード() {
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
}
