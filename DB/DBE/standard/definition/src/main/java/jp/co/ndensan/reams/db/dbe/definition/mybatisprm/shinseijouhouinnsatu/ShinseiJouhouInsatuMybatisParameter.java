package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseijouhouinnsatu;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 申請情報印刷のMybatisパラメータクラスです。
 *
 * @reamsid_L DBE-1390-020 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class ShinseiJouhouInsatuMybatisParameter implements IMyBatisParameter {

    private final RString sakuseijyouken;
    private final RDateTime shorikaFrom;
    private final RDateTime shorikaTo;
    private final FlexibleDate shinnseikaFrom;
    private final FlexibleDate shinnseikaTo;
    private final boolean sakuseijyoukenuser;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     * @param sakuseijyouken 作成条件
     * @param shorikaFrom 処理日From
     * @param shorikaTo 処理日To
     * @param shinnseikaFrom 申請日From
     * @param shinnseikaTo 申請日To
     * @param sakuseijyoukenuser 作成条件
     * @param psmShikibetsuTaisho 宛名PSM
     */
    protected ShinseiJouhouInsatuMybatisParameter(RString sakuseijyouken,
            RDateTime shorikaFrom,
            RDateTime shorikaTo,
            FlexibleDate shinnseikaFrom,
            FlexibleDate shinnseikaTo,
            boolean sakuseijyoukenuser,
            RString psmShikibetsuTaisho
    ) {
        this.sakuseijyouken = sakuseijyouken;
        this.shorikaFrom = shorikaFrom;
        this.shorikaTo = shorikaTo;
        this.shinnseikaFrom = shinnseikaFrom;
        this.shinnseikaTo = shinnseikaTo;
        this.sakuseijyoukenuser = sakuseijyoukenuser;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     *
     * @param sakuseijyouken 作成条件
     * @param shorikaFrom 処理日From
     * @param shorikaTo 処理日To
     * @param shinnseikaFrom 申請日From
     * @param shinnseikaTo 申請日To
     * @param sakuseijyoukenuser 作成条件
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @return HanteiKekkaJohoShuturyokuMybatisParameter
     */
    public static ShinseiJouhouInsatuMybatisParameter creatParameter(RString sakuseijyouken,
            RDateTime shorikaFrom,
            RDateTime shorikaTo,
            FlexibleDate shinnseikaFrom,
            FlexibleDate shinnseikaTo,
            boolean sakuseijyoukenuser,
            RString psmShikibetsuTaisho) {
        return new ShinseiJouhouInsatuMybatisParameter(
                sakuseijyouken,
                shorikaFrom,
                shorikaTo,
                shinnseikaFrom,
                shinnseikaTo,
                new RString("1").equals(sakuseijyouken),
                psmShikibetsuTaisho);
    }
}
