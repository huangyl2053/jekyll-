/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.nenreikaikyuriyojokyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 給付実績データ取得処理Mybatis用パラメータクラスです。
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KyufujissekiDataMybatisParameter implements IMyBatisParameter {

    private static final RString 市町村特別給付 = new RString("市町村特別給付");
    private static final RString 食費 = new RString("(介護予防)特定入所者介護サービス費(食費)");
    private static final RString 居住費 = new RString("(介護予防)特定入所者介護サービス費(居住費)");
    private final RString serviceSyuruiCodeMei;
    private final List<RString> serviceSyuruiCodeList;
    private final boolean tokubetuKyuuhu;
    private final boolean shokuhi;
    private final boolean kyojuuhi;

    /**
     * コンストラクタです。
     *
     * @param serviceSyuruiCodeMei サービス種類コード名
     * @param serviceSyuruiCodeList サービス種類コード
     * @param tokubetuKyuuhu 市町村特別給付
     * @param shokuhi (介護予防)特定入所者介護サービス費(食費)
     * @param kyojuuhi (介護予防)特定入所者介護サービス費(居住費)
     */
    protected KyufujissekiDataMybatisParameter(RString serviceSyuruiCodeMei,
            List<RString> serviceSyuruiCodeList,
            boolean tokubetuKyuuhu,
            boolean shokuhi,
            boolean kyojuuhi) {
        this.serviceSyuruiCodeMei = serviceSyuruiCodeMei;
        this.serviceSyuruiCodeList = serviceSyuruiCodeList;
        this.tokubetuKyuuhu = tokubetuKyuuhu;
        this.shokuhi = shokuhi;
        this.kyojuuhi = kyojuuhi;
    }

    /**
     * コンストラクタです。
     *
     * @param serviceSyuruiCodeMei サービス種類コード名
     * @param serviceSyuruiCodeList サービス種類コード
     * @return KyufujissekiDataMybatisParameter
     */
    public static KyufujissekiDataMybatisParameter createParam(RString serviceSyuruiCodeMei,
            List<RString> serviceSyuruiCodeList) {
        boolean tokubetuKyuuhuFlag = false;
        boolean shokuhiFlag = false;
        boolean kyojuuhiFlag = false;
        if (市町村特別給付.equals(serviceSyuruiCodeMei)) {
            tokubetuKyuuhuFlag = true;
        }
        if (食費.equals(serviceSyuruiCodeMei)) {
            shokuhiFlag = true;
        }
        if (居住費.equals(serviceSyuruiCodeMei)) {
            kyojuuhiFlag = true;
        }
        return new KyufujissekiDataMybatisParameter(serviceSyuruiCodeMei,
                serviceSyuruiCodeList,
                tokubetuKyuuhuFlag,
                shokuhiFlag,
                kyojuuhiFlag);
    }

}
