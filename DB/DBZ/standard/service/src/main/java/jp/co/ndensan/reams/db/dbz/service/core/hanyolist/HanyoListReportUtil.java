/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.hanyolist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.hanyolist.HanyoListShutsuryokuKomoku;
import jp.co.ndensan.reams.db.dbz.business.core.hanyolist.HanyoListShutsuryokuKomokuList;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.reportoutputitem.UrT0072ShutsuryokuKomokuKanriEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.reportoutputitem.UrT0073ShutsuryokuKomokuSetteiEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.reportoutputitemkanri.UrT0171ChohyoShutsuryokuKomokuKanriEntity;
import jp.co.ndensan.reams.ur.urz.persistence.db.basic.reportoutputitem.UrT0072ShutsuryokuKomokuKanriDac;
import jp.co.ndensan.reams.ur.urz.persistence.db.basic.reportoutputitem.UrT0073ShutsuryokuKomokuSetteiDac;
import jp.co.ndensan.reams.ur.urz.persistence.db.basic.reportoutputitemkanri.UrT0171ChohyoShutsuryokuKomokuKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBZMNnnnnn_汎用リストのビジネス
 *
 * @reamsid_L DBZ-4570-010 jinge
 */
public class HanyoListReportUtil {

    private final UrT0072ShutsuryokuKomokuKanriDac urT0072dac;
    private final UrT0073ShutsuryokuKomokuSetteiDac urT0073dac;
    private final UrT0171ChohyoShutsuryokuKomokuKanriDac urT0171dac;
    private final MapperProvider mapperProvider;
    private IOutputOrder outputOrder;
    private static final int NUM5 = 5;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final RString QUOTES = new RString("\"");

    /**
     * コンストラクタです。
     */
    HanyoListReportUtil() {
        this.urT0072dac = InstanceProvider.create(UrT0072ShutsuryokuKomokuKanriDac.class);
        this.urT0073dac = InstanceProvider.create(UrT0073ShutsuryokuKomokuSetteiDac.class);
        this.urT0171dac = InstanceProvider.create(UrT0171ChohyoShutsuryokuKomokuKanriDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HanyoListReportUtil}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HanyoListReportUtil}のインスタンス
     */
    public static HanyoListReportUtil createInstance() {
        return InstanceProvider.create(HanyoListReportUtil.class);
    }

    public HanyoListShutsuryokuKomoku get汎用リスト出力項目(GyomuCode 業務コード, SubGyomuCode サブ業務コード, ReportId 帳票ID, long 出力項目ID) throws NullPointerException {
        HanyoListShutsuryokuKomoku hanyoList = new HanyoListShutsuryokuKomoku();
        UrT0072ShutsuryokuKomokuKanriEntity urT0072Entity = urT0072dac.selectByKey(サブ業務コード, 帳票ID, 出力項目ID);
        if (urT0072Entity != null) {
            hanyoList.set項目間スペース数(urT0072Entity.getKomokukanSpace());
        } else {
            return null;
        }
        List<UrT0073ShutsuryokuKomokuSetteiEntity> urT0073Entity = urT0073dac.selectByKey(サブ業務コード, 帳票ID, 出力項目ID, 業務コード);
        List<RString> 項目ID = new ArrayList();
        if (urT0073Entity != null && !urT0073Entity.isEmpty()) {
            for (int index = 0; index < urT0073Entity.size(); index++) {
                hanyoList.get汎用リスト出力項目リスト().get(index).set項目ID(urT0073Entity.get(index).getShutsuryokuKomokuId());
                hanyoList.get汎用リスト出力項目リスト().get(index).set出力項目順位(urT0073Entity.get(index).getShutsuryokuKomokuJuni());
                hanyoList.get汎用リスト出力項目リスト().get(index).set省略区分(urT0073Entity.get(index).getShoryakuKubun());
                hanyoList.get汎用リスト出力項目リスト().get(index).set出力項目文字数(urT0073Entity.get(index).getShutsuryokuKomokuMojisu());
                hanyoList.get汎用リスト出力項目リスト().get(index).set出力項目日付区分(urT0073Entity.get(index).getShutsuryokuKomokuHizukeKubun());
                項目ID.add(new RString(urT0073Entity.get(index).getShutsuryokuKomokuId()));
            }
        } else {
            return null;
        }
        if (!項目ID.isEmpty()) {
            for (int index = 0; index < 項目ID.size(); index++) {
                UrT0171ChohyoShutsuryokuKomokuKanriEntity urT0171Entity = urT0171dac.selectByKey(業務コード, 項目ID.get(index));
                if (urT0171Entity != null) {
                    hanyoList.get汎用リスト出力項目リスト().get(index).set項目名称(urT0171Entity.getKomokuMei());
                    hanyoList.get汎用リスト出力項目リスト().get(index).set項目桁数(urT0171Entity.getKaiPeijiKetasu());
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
        Collections.sort(hanyoList.get汎用リスト出力項目リスト(), new Comparator<HanyoListShutsuryokuKomokuList>() {
            @Override
            public int compare(HanyoListShutsuryokuKomokuList result1, HanyoListShutsuryokuKomokuList result2) {
                if (result1.get出力項目順位() < result2.get出力項目順位()) {
                    return -1;
                } else if (result1.get出力項目順位() > result2.get出力項目順位()) {
                    return 1;
                } else {
                    return result1.get項目ID() < result2.get項目ID() ? -1 : 1;
                }
            }
        });
        hanyoList.set汎用リスト出力項目リスト(hanyoList.get汎用リスト出力項目リスト());
        return hanyoList;
    }

    public void get汎用リスト項目位置(ReportId 帳票ID, RString 項目ID) throws NullPointerException {

    }

    /*public void 汎用リスト帳票出力(RString 汎用リスト一時テーブル名, SubGyomuCode サブ業務コード, HanyoListParameter param) throws NullPointerException {
     Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
     IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
     outputOrder = finder.get出力順(サブ業務コード, param.get帳票ID(), Long.parseLong(param.get出力順().toString()));
     RString 出力順 = RString.EMPTY;
     if (outputOrder != null) {
     出力順 = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.
     create(HanyoListProperty.HanyoListEnum.class, outputOrder), NUM5);
     }
     RString 改頁項目ID = outputOrder.get改頁項目ID();
     汎用リスト一時テーブル名 = QUOTES.concat(汎用リスト一時テーブル名).concat(QUOTES);
     HanyoListTempTableNameParameter parameter = new HanyoListTempTableNameParameter(汎用リスト一時テーブル名);
     IHanyoListTempTableMapper mapper = mapperProvider.create(IHanyoListTempTableMapper.class);
     HanyoListTempEntity entity = mapper.select汎用リスト一時テーブル(parameter);
     if (entity != null) {
     HanyoListReport hanyoListReport = new HanyoListReport(param.get表題(), param.getデータ種別名(),
     entity.get項目見出し(), entity.get項目内容(), 地方公共団体, outputOrder);
     }
     List<RString> pageBreakKeys = new ArrayList<>();
     RString 改頁１ = RString.EMPTY;
     RString 改頁２ = RString.EMPTY;
     RString 改頁３ = RString.EMPTY;
     RString 改頁４ = RString.EMPTY;
     RString 改頁５ = RString.EMPTY;
     Map<Integer, ISetSortItem> 改頁Map = ChohyoUtil.get改頁項目Map(outputOrder);
     if (改頁Map.get(INDEX_1) != null) {
     改頁１ = to帳票物理名(改頁Map.get(INDEX_1));
     }
     if (改頁Map.get(INDEX_2) != null) {
     改頁２ = to帳票物理名(改頁Map.get(INDEX_2));
     }
     if (改頁Map.get(INDEX_3) != null) {
     改頁３ = to帳票物理名(改頁Map.get(INDEX_3));
     }
     if (改頁Map.get(INDEX_4) != null) {
     改頁４ = to帳票物理名(改頁Map.get(INDEX_4));
     }
     if (改頁Map.get(INDEX_5) != null) {
     改頁５ = to帳票物理名(改頁Map.get(INDEX_5));
     }

     if (改頁１ != null && !改頁１.isEmpty()) {
     pageBreakKeys.add(改頁１);
     }
     if (改頁２ != null && !改頁２.isEmpty()) {
     pageBreakKeys.add(改頁２);
     }
     if (改頁３ != null && !改頁３.isEmpty()) {
     pageBreakKeys.add(改頁３);
     }
     if (改頁４ != null && !改頁４.isEmpty()) {
     pageBreakKeys.add(改頁４);
     }
     if (改頁５ != null && !改頁５.isEmpty()) {
     pageBreakKeys.add(改頁５);
     }
     }*/

    /*private RString to帳票物理名(ISetSortItem item) {

     RString 帳票物理名 = RString.EMPTY;

     if (HanyoListEnum.郵便番号.get項目ID().equals(item.get項目ID())) {
     帳票物理名 = HanyoListReportSource.改頁_郵便;
     } else if (HanyoListEnum.行政区コード.get項目ID().equals(item.get項目ID())) {
     帳票物理名 = HanyoListReportSource.改頁_行政区コード;
     } else if (HanyoListEnum.世帯コード.get項目ID().equals(item.get項目ID())) {
     帳票物理名 = HanyoListReportSource.改頁_世帯コード;
     } else if (HanyoListEnum.生年月日.get項目ID().equals(item.get項目ID())) {
     帳票物理名 = HanyoListReportSource.改頁_生年月日;
     } else if (HanyoListEnum.性別.get項目ID().equals(item.get項目ID())) {
     帳票物理名 = HanyoListReportSource.改頁_性別;
     } else if (HanyoListEnum.市町村コード.get項目ID().equals(item.get項目ID())) {
     帳票物理名 = HanyoListReportSource.改頁_市町村コード;
     }
     return 帳票物理名;
     }*/
}
