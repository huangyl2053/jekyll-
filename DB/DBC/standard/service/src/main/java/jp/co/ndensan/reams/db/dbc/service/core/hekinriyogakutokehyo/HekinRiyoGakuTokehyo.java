/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.hekinriyogakutokehyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.KyufujissekiTempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.ShukeinaiyouEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.SyorikekkatempTblEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hekinriyogakutokehyo.IHekinRiyoGakuTokehyoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai.住民;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBC150040_平均利用額統計表作成のビジネスクラスです。
 *
 * @reamsid_L DBC-3490-050 yaoyahui
 */
public class HekinRiyoGakuTokehyo {

    private final MapperProvider mapperProvider;
    private static final RString エラー内容1 = new RString("不整合データ：３９歳以下の被保険者です。");
    private static final RString エラー内容2 = new RString("不整合データ：６５歳以上の被保険者です。");
    private static final RString 備考 = new RString("所得段階が取得できません。その他に集計されます。");
    private static final RString 集計処理 = new RString("集計処理");
    private static final int 年齢1 = 39;
    private static final int 年齢2 = 65;
    private static final int 值十 = 10;
    private static final int 值九 = 9;
    private static final int 值一 = 1;
    private RString 被保険者番号 = RString.EMPTY;
    private FlexibleYearMonth サービス提供年月 = FlexibleYearMonth.EMPTY;
    private RString 要介護状態区分コード = RString.EMPTY;
    private RString サービス分類 = RString.EMPTY;
    private RString サービス分類コード = RString.EMPTY;
    private IHekinRiyoGakuTokehyoMapper mapper;
    private static final int 值0 = 0;
    private static final RString 值1 = new RString("1");
    private static final RString 值2 = new RString("2");
    private static final RString 值3 = new RString("3");
    private static final RString 值4 = new RString("4");
    private static final RString 值5 = new RString("5");
    private static final RString 值6 = new RString("6");
    private static final RString 值7 = new RString("7");
    private static final RString 值8 = new RString("8");
    private static final RString 值9 = new RString("9");
    private static final RString 以上 = new RString("10以上");
    private static final RString その他 = new RString("その他");
    private static final RString 号 = new RString("２号");
    private static final RString 合計 = new RString("合計");

    /**
     * コンストラクタです。
     */
    public HekinRiyoGakuTokehyo() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HekinRiyoGakuTokehyo}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HekinRiyoGakuTokehyo}のインスタンス
     */
    public static HekinRiyoGakuTokehyo createInstance() {
        return InstanceProvider.create(HekinRiyoGakuTokehyo.class);
    }

    /**
     * get給付実績データ取得処理
     *
     */
    public void get給付実績データ取得処理() {
        mapper = mapperProvider.create(IHekinRiyoGakuTokehyoMapper.class);
        List<KyufujissekiTempTblEntity> entityList = mapper.get給付実績データ取得処理();
        List<List<ShukeinaiyouEntity>> shukeinaiyouEntityList = new ArrayList<>();
        if (!entityList.isEmpty()) {
            shukeinaiyouEntityList = createntitylist();
            サービス分類コード = entityList.get(0).getServiceBunrui();
        }
        for (int i = 0; i < entityList.size(); i++) {
            if (!サービス分類コード.equals(entityList.get(i).getServiceBunrui())) {
                updateDB出力出力用一時TBL(shukeinaiyouEntityList, mapper);
                shukeinaiyouEntityList = createntitylist();
                サービス分類コード = entityList.get(i).getServiceBunrui();
            }
            if (!RString.isNullOrEmpty(entityList.get(i).getHiHokenshaNo())) {
                edit対象レコード(shukeinaiyouEntityList, entityList.get(i), mapper);
            }
        }
    }

    private List<List<ShukeinaiyouEntity>> edit対象レコード(List<List<ShukeinaiyouEntity>> shukeinaiyouEntityList,
            KyufujissekiTempTblEntity レコード, IHekinRiyoGakuTokehyoMapper mapper) {

        int 人数 = get対象レコード人数(レコード);
        int 費用金額 = get費用金額(レコード);
        get対象レコード年齢の処理(shukeinaiyouEntityList, レコード, 人数, 費用金額, mapper);
        get所得段階判定(shukeinaiyouEntityList, レコード, 人数, 費用金額);
        return shukeinaiyouEntityList;
    }

    /**
     * get対象レコード人数
     *
     * @param レコード レコード
     * @return count 人数
     */
    private int get対象レコード人数(KyufujissekiTempTblEntity レコード) {
        int count = 0;
        if (!被保険者番号.equals(レコード.getHiHokenshaNo())
                && !サービス提供年月.toString().equals(レコード.getServiceTeikyoYM().toString())
                && !要介護状態区分コード.equals(レコード.getYoKaigoJotaiKubunCode()) && !サービス分類.equals(レコード.getServiceBunrui())) {
            被保険者番号 = レコード.getHiHokenshaNo();
            サービス提供年月 = レコード.getServiceTeikyoYM();
            要介護状態区分コード = レコード.getYoKaigoJotaiKubunCode();
            サービス分類 = レコード.getServiceBunrui();
            count++;
        }
        return count;
    }

    /**
     *
     * @param shukeinaiyouEntityList
     * @param レコード レコード
     * @param 人数
     * @param 費用金額
     */
    private void get対象レコード年齢の処理(List<List<ShukeinaiyouEntity>> shukeinaiyouEntityList, KyufujissekiTempTblEntity レコード,
            int 人数, int 費用金額, IHekinRiyoGakuTokehyoMapper mapper) {
        AgeCalculator agecounter = new AgeCalculator(DateOfBirthFactory.createInstance(レコード.getUmareYMD()), 住民, FlexibleDate.EMPTY);
        RString 年齢 = agecounter.get年齢();
        int age = Integer.valueOf(年齢.toString());
        if (年齢1 > age || (age == 年齢1 && レコード.getServiceTeikyoYM().toString().equals(レコード.getUmareYMD().toString()))) {
            SyorikekkatempTblEntity entity = new SyorikekkatempTblEntity();
            entity.setErrorkubun(集計処理);
            entity.setHiHokenshaNo(レコード.getHiHokenshaNo());
            entity.setKi1(レコード.getServiceTeikyoYM());
            entity.setKi2(レコード.getUmareYMD());
            entity.setKi3(RString.EMPTY);
            entity.setKi4(RString.EMPTY);
            entity.setKi5(RString.EMPTY);
            entity.setErrornaiyo(エラー内容1);
            entity.setBiko(備考);
            mapper.insert処理結果リスト一時TBL(entity);
        } else if (age >= 年齢2) {
            SyorikekkatempTblEntity entity = new SyorikekkatempTblEntity();
            entity.setErrorkubun(集計処理);
            entity.setHiHokenshaNo(レコード.getHiHokenshaNo());
            entity.setKi1(レコード.getServiceTeikyoYM());
            entity.setKi2(レコード.getUmareYMD());
            entity.setKi3(RString.EMPTY);
            entity.setKi4(RString.EMPTY);
            entity.setKi5(RString.EMPTY);
            entity.setErrornaiyo(エラー内容2);
            entity.setBiko(備考);
            mapper.insert処理結果リスト一時TBL(entity);
        } else {
            updatecreatentitylist(shukeinaiyouEntityList, レコード,
                    人数,
                    費用金額, 号, レコード.getYoKaigoJotaiKubunCode());
        }
    }

    private void get所得段階判定(List<List<ShukeinaiyouEntity>> shukeinaiyouEntityList, KyufujissekiTempTblEntity レコード,
            int 人数, int 費用総額) {
        RString shotoku = レコード.getShotoku();
        if (RString.isNullOrEmpty(shotoku)) {
            updatecreatentitylist(shukeinaiyouEntityList,
                    レコード,
                    人数,
                    費用総額,
                    レコード.getShotoku(),
                    レコード.getYoKaigoJotaiKubunCode()
            );
            updatecreatentitylist(shukeinaiyouEntityList, レコード,
                    人数,
                    費用総額, 合計, レコード.getYoKaigoJotaiKubunCode());
        } else if (new RString("10以上").equals(shotoku)) {
            updatecreatentitylist(shukeinaiyouEntityList,
                    レコード,
                    人数,
                    費用総額,
                    レコード.getShotoku(),
                    レコード.getYoKaigoJotaiKubunCode());
            updatecreatentitylist(shukeinaiyouEntityList, レコード,
                    人数,
                    費用総額, 合計, レコード.getYoKaigoJotaiKubunCode());
        } else if (shotoku.length() <= 值九 && 值一 <= shotoku.length()) {
            updatecreatentitylist(shukeinaiyouEntityList,
                    レコード,
                    人数,
                    費用総額,
                    レコード.getShotoku(),
                    レコード.getYoKaigoJotaiKubunCode());
            updatecreatentitylist(shukeinaiyouEntityList, レコード,
                    人数,
                    費用総額, 合計, レコード.getYoKaigoJotaiKubunCode());
        }

    }

    private int get費用金額(KyufujissekiTempTblEntity レコード) {

        RString サービス種類コード = レコード.getServiceSyuruiCode();
        RString 保険請求額 = レコード.getHokenSeikyuKingaku();
        RString 保険者利用負担額 = レコード.getHokenRiyoshaFutangaku();
        RString 保険単位数 = レコード.getHokenTanisu();
        RString 保険単位単価数 = レコード.getHokenTanisuTani();
        RString 保険出来高点数 = レコード.getHokenDekidakaTanisu();
        int 費用金額 = 0;
        if (new RString("41").equals(サービス種類コード) || new RString("42").equals(サービス種類コード)
                || new RString("44").equals(サービス種類コード) || new RString("45").equals(サービス種類コード)) {
            if (!RString.isNullOrEmpty(保険請求額) && !RString.isNullOrEmpty(保険者利用負担額)) {
                費用金額 = Integer.valueOf(保険請求額.toString()) + Integer.valueOf(保険者利用負担額.toString());
            }
        } else if (new RString("43").equals(サービス種類コード) || new RString("46").equals(サービス種類コード)) {
            if (!RString.isNullOrEmpty(保険請求額)) {
                費用金額 = Integer.valueOf(保険請求額.toString());
            }
        } else if (new RString("59").equals(サービス種類コード)) {
            if (被保険者番号.equals(レコード.getHiHokenshaNo()) && サービス提供年月.equals(レコード.getServiceTeikyoYM())
                    && 要介護状態区分コード.equals(レコード.getYoKaigoJotaiKubunCode())) {
                費用金額 = 費用金額 + Integer.valueOf(レコード.getHiyosogaku().toString());
            }
        } else {
            if (!RString.isNullOrEmpty(保険単位数) && !RString.isNullOrEmpty(保険単位単価数) && !RString.isNullOrEmpty(保険出来高点数)) {
                費用金額 = (Integer.valueOf(保険単位数.toString()) * Integer.valueOf(保険単位単価数.toString()))
                        + (Integer.valueOf(保険出来高点数.toString()) * 值十);
            }
        }
        return 費用金額;
    }

    private List<List<ShukeinaiyouEntity>> updatecreatentitylist(List<List<ShukeinaiyouEntity>> shukeinaiyouEntityList,
            KyufujissekiTempTblEntity レコード,
            int 人数,
            int 費用総額,
            RString 所得段階,
            RString 要介護状態区分コード
    ) {
        for (List<ShukeinaiyouEntity> list : shukeinaiyouEntityList) {
            for (ShukeinaiyouEntity shukeinaiyouEntity : list) {
                if (所得段階.equals(shukeinaiyouEntity.get所得段階()) && 要介護状態区分コード.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                    shukeinaiyouEntity.setページNo(レコード.getServiceBunrui());
                    shukeinaiyouEntity.set人数(人数);
                    shukeinaiyouEntity.set費用総額(費用総額);
                }
            }
        }
        return shukeinaiyouEntityList;
    }

    private List<List<ShukeinaiyouEntity>> createntitylist() {
        List<RString> shotokuList = new ArrayList<>();
        shotokuList.add(值1);
        shotokuList.add(值2);
        shotokuList.add(值3);
        shotokuList.add(值4);
        shotokuList.add(值5);
        shotokuList.add(值6);
        shotokuList.add(值7);
        shotokuList.add(值8);
        shotokuList.add(值9);
        shotokuList.add(以上);
        shotokuList.add(その他);
        shotokuList.add(号);
        shotokuList.add(合計);
        List<List<ShukeinaiyouEntity>> entitylist = new ArrayList<>();
        for (int i = 0; i < shotokuList.size(); i++) {
            List<ShukeinaiyouEntity> 所得段階別集計list = new ArrayList<>();
            ShukeinaiyouEntity 要介護度別集計1 = new ShukeinaiyouEntity();
            要介護度別集計1.setページNo(RString.EMPTY);
            要介護度別集計1.set費用総額(0);
            要介護度別集計1.set人数(值0);
            要介護度別集計1.set所得段階(shotokuList.get(i));
            要介護度別集計1.set要介護状態区分コード(new RString("12"));
            所得段階別集計list.add(要介護度別集計1);
            ShukeinaiyouEntity 要介護度別集計2 = new ShukeinaiyouEntity();
            要介護度別集計2.setページNo(RString.EMPTY);
            要介護度別集計2.set費用総額(值0);
            要介護度別集計2.set人数(值0);
            要介護度別集計2.set所得段階(shotokuList.get(i));
            要介護度別集計2.set要介護状態区分コード(new RString("13"));
            所得段階別集計list.add(要介護度別集計2);
            ShukeinaiyouEntity 要介護度別集計3 = new ShukeinaiyouEntity();
            要介護度別集計3.setページNo(RString.EMPTY);
            要介護度別集計3.set費用総額(值0);
            要介護度別集計3.set人数(值0);
            要介護度別集計3.set所得段階(shotokuList.get(i));
            要介護度別集計3.set要介護状態区分コード(new RString("11"));
            所得段階別集計list.add(要介護度別集計3);
            ShukeinaiyouEntity 要介護度別集計4 = new ShukeinaiyouEntity();
            要介護度別集計4.setページNo(RString.EMPTY);
            要介護度別集計4.set費用総額(值0);
            要介護度別集計4.set人数(值0);
            要介護度別集計4.set所得段階(shotokuList.get(i));
            要介護度別集計4.set要介護状態区分コード(new RString("21"));
            所得段階別集計list.add(要介護度別集計4);
            ShukeinaiyouEntity 要介護度別集計5 = new ShukeinaiyouEntity();
            要介護度別集計5.setページNo(RString.EMPTY);
            要介護度別集計5.set費用総額(值0);
            要介護度別集計5.set人数(值0);
            要介護度別集計5.set所得段階(shotokuList.get(i));
            要介護度別集計5.set要介護状態区分コード(new RString("22"));
            所得段階別集計list.add(要介護度別集計5);
            ShukeinaiyouEntity 要介護度別集計6 = new ShukeinaiyouEntity();
            要介護度別集計6.setページNo(RString.EMPTY);
            要介護度別集計6.set費用総額(值0);
            要介護度別集計6.set人数(值0);
            要介護度別集計6.set所得段階(shotokuList.get(i));
            要介護度別集計6.set要介護状態区分コード(new RString("23"));
            所得段階別集計list.add(要介護度別集計6);
            ShukeinaiyouEntity 要介護度別集計7 = new ShukeinaiyouEntity();
            要介護度別集計7.setページNo(RString.EMPTY);
            要介護度別集計7.set費用総額(值0);
            要介護度別集計7.set人数(值0);
            要介護度別集計7.set所得段階(shotokuList.get(i));
            要介護度別集計7.set要介護状態区分コード(new RString("24"));
            所得段階別集計list.add(要介護度別集計7);
            ShukeinaiyouEntity 要介護度別集計8 = new ShukeinaiyouEntity();
            要介護度別集計8.setページNo(RString.EMPTY);
            要介護度別集計8.set費用総額(值0);
            要介護度別集計8.set人数(值0);
            要介護度別集計8.set所得段階(shotokuList.get(i));
            要介護度別集計8.set要介護状態区分コード(new RString("25"));
            所得段階別集計list.add(要介護度別集計8);
            entitylist.add(所得段階別集計list);
        }
        return entitylist;
    }

    private void updateDB出力出力用一時TBL(List<List<ShukeinaiyouEntity>> shukeinaiyouEntityList, IHekinRiyoGakuTokehyoMapper mapper) {
        for (List<ShukeinaiyouEntity> list : shukeinaiyouEntityList) {
            for (ShukeinaiyouEntity shukeinaiyouEntity : list) {
                if (shukeinaiyouEntity.get人数() > 0) {
                    shukeinaiyouEntity.set集計内容(new RString("人数"));
                    mapper.updateDB出力出力用一時TBL人数(shukeinaiyouEntity);
                }
                if (shukeinaiyouEntity.get費用総額() > 0) {
                    shukeinaiyouEntity.set集計内容(new RString("費用総額"));
                    mapper.updateDB出力出力用一時TBL費用総額(shukeinaiyouEntity);
                }
            }
        }
    }
}
