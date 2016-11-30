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
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hekinriyogakutokehyo.IHekinRiyoGakuTokehyoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBC150040_平均利用額統計表作成のビジネスクラスです。
 *
 * @reamsid_L DBC-3490-050 yaoyahui
 */
public class HekinRiyoGakuTokehyo {

    private final MapperProvider mapperProvider;
    private static final int 計算用十 = 10;
    private static final int 定数9 = 9;
    private static final RString 要介護状態区分コード11 = new RString("11");
    private static final RString 要介護状態区分コード12 = new RString("12");
    private static final RString 要介護状態区分コード13 = new RString("13");
    private static final RString 要介護状態区分コード21 = new RString("21");
    private static final RString 要介護状態区分コード22 = new RString("22");
    private static final RString 要介護状態区分コード23 = new RString("23");
    private static final RString 要介護状態区分コード24 = new RString("24");
    private static final RString 要介護状態区分コード25 = new RString("25");
    private static final RString サービス種類コード41 = new RString("41");
    private static final RString サービス種類コード42 = new RString("42");
    private static final RString サービス種類コード43 = new RString("43");
    private static final RString サービス種類コード44 = new RString("44");
    private static final RString サービス種類コード45 = new RString("45");
    private static final RString サービス種類コード46 = new RString("46");
    private static final RString サービス種類コード59 = new RString("59");
    private static final RString 人 = new RString("人数");
    private static final RString 費用総額 = new RString("費用総額");
    private RString 被保険者番号 = RString.EMPTY;
    private FlexibleYearMonth サービス提供年月 = FlexibleYearMonth.EMPTY;
    private RString 要介護状態区分コード = RString.EMPTY;
    private RString サービス分類 = RString.EMPTY;
    private static final RString 所得段階_1 = new RString("1");
    private static final RString 所得段階_2 = new RString("2");
    private static final RString 所得段階_3 = new RString("3");
    private static final RString 所得段階_4 = new RString("4");
    private static final RString 所得段階_5 = new RString("5");
    private static final RString 所得段階_6 = new RString("6");
    private static final RString 所得段階_7 = new RString("7");
    private static final RString 所得段階_8 = new RString("8");
    private static final RString 所得段階_9 = new RString("9");
    private static final RString 所得段階_10以上 = new RString("10以上");
    private static final RString 所得段階_その他 = new RString("その他");
    private static final RString 所得段階_号 = new RString("２号");
    private static final RString 所得段階_合計 = new RString("合計");
    private static final RString 総合計_ページ = new RString("36");
    private Decimal 費用総額59 = Decimal.ZERO;

    /**
     * コンストラクタです。
     */
    public HekinRiyoGakuTokehyo() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HekinRiyoGakuTokehyo}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HekinRiyoGakuTokehyo}のインスタンス
     */
    public static HekinRiyoGakuTokehyo createInstance() {
        return InstanceProvider.create(HekinRiyoGakuTokehyo.class);
    }

    /**
     * get給付実績データ取得処理
     *
     */
    public void get給付実績データ取得処理() {

        IHekinRiyoGakuTokehyoMapper mapper = mapperProvider.create(IHekinRiyoGakuTokehyoMapper.class);
        List<KyufujissekiTempTblEntity> entityList = mapper.get給付実績データ取得処理();
        List<List<ShukeinaiyouEntity>> shukeinaiyouEntityList;
        if (!entityList.isEmpty()) {
            shukeinaiyouEntityList = createntitylist();
            サービス分類 = entityList.get(0).getServiceBunrui();
            被保険者番号 = entityList.get(0).getHiHokenshaNo();
            サービス提供年月 = entityList.get(0).getServiceTeikyoYM();
            if (entityList.get(0).getYoKaigoJotaiKubunCode() != null) {
                要介護状態区分コード = entityList.get(0).getYoKaigoJotaiKubunCode();
            } else {
                要介護状態区分コード = RString.EMPTY;
            }
            int 人数 = 1;
            for (int i = 0; i < entityList.size(); i++) {
                KyufujissekiTempTblEntity レコード = entityList.get(i);
                if (被保険者番号.equals(レコード.getHiHokenshaNo())
                        && サービス提供年月.toString().equals(レコード.getServiceTeikyoYM().toString())
                        && 要介護状態区分コード.equals(レコード.getYoKaigoJotaiKubunCode()) && サービス分類.equals(レコード.getServiceBunrui())) {
                    被保険者番号 = レコード.getHiHokenshaNo();
                    サービス提供年月 = レコード.getServiceTeikyoYM();
                    setYoKaigoJotaiKubunCode(レコード);
                    サービス分類 = レコード.getServiceBunrui();
                    人数++;
                } else {
                    人数 = 1;
                }
                edit対象レコード(shukeinaiyouEntityList, レコード, 人数);
                if (!サービス分類.equals(entityList.get(i).getServiceBunrui())) {
                    updateDB出力出力用一時TBL(shukeinaiyouEntityList, mapper);
                    shukeinaiyouEntityList = createntitylist();
                    サービス分類 = entityList.get(i).getServiceBunrui();
                }
            }
        }
    }

    private void setYoKaigoJotaiKubunCode(KyufujissekiTempTblEntity レコード) {
        if (レコード.getYoKaigoJotaiKubunCode() != null) {
            要介護状態区分コード = レコード.getYoKaigoJotaiKubunCode();
        } else {
            要介護状態区分コード = RString.EMPTY;
        }
    }

    private List<List<ShukeinaiyouEntity>> edit対象レコード(List<List<ShukeinaiyouEntity>> shukeinaiyouEntityList,
            KyufujissekiTempTblEntity レコード, int 人数) {
        Decimal 費用金額 = get費用金額(レコード);
        get所得段階判定(shukeinaiyouEntityList, レコード, 人数, 費用金額);
        return shukeinaiyouEntityList;
    }

    private void get所得段階判定(List<List<ShukeinaiyouEntity>> shukeinaiyouEntityList, KyufujissekiTempTblEntity レコード,
            int 人数, Decimal 費用総額) {
        RString shotoku = レコード.getShotoku();
        if (所得段階_号.equals(shotoku)) {
            updatecreatentitylist(shukeinaiyouEntityList,
                    レコード,
                    人数,
                    費用総額,
                    所得段階_号,
                    レコード.getYoKaigoJotaiKubunCode());
            updatecreatentitylist(shukeinaiyouEntityList, レコード,
                    人数,
                    費用総額, 所得段階_合計, レコード.getYoKaigoJotaiKubunCode());
        } else {
            if (RString.isNullOrEmpty(shotoku)) {
                updatecreatentitylist(shukeinaiyouEntityList,
                        レコード,
                        人数,
                        費用総額,
                        所得段階_その他,
                        レコード.getYoKaigoJotaiKubunCode()
                );
                updatecreatentitylist(shukeinaiyouEntityList, レコード,
                        人数,
                        費用総額, 所得段階_合計, レコード.getYoKaigoJotaiKubunCode());
            } else if (計算用十 < Integer.valueOf(shotoku.toString())) {
                updatecreatentitylist(shukeinaiyouEntityList,
                        レコード,
                        人数,
                        費用総額,
                        所得段階_10以上,
                        レコード.getYoKaigoJotaiKubunCode());
                updatecreatentitylist(shukeinaiyouEntityList, レコード,
                        人数,
                        費用総額, 所得段階_合計, レコード.getYoKaigoJotaiKubunCode());
            } else if (Integer.valueOf(shotoku.toString()) <= 定数9 && 1 <= Integer.valueOf(shotoku.toString())) {
                updatecreatentitylist(shukeinaiyouEntityList,
                        レコード,
                        人数,
                        費用総額,
                        new RString(Integer.valueOf(shotoku.toString())),
                        レコード.getYoKaigoJotaiKubunCode());
                updatecreatentitylist(shukeinaiyouEntityList, レコード,
                        人数,
                        費用総額, 所得段階_合計, レコード.getYoKaigoJotaiKubunCode());
            }
        }
    }

    private Decimal get費用金額(KyufujissekiTempTblEntity レコード) {
        RString サービス種類コード = レコード.getServiceSyuruiCode();
        RString 保険請求額 = レコード.getHokenSeikyuKingaku();
        RString 保険者利用負担額 = レコード.getHokenRiyoshaFutangaku();
        RString 保険単位数 = レコード.getHokenTanisu();
        RString 保険単位単価数 = レコード.getHokenTanisuTani();
        RString 保険出来高点数 = レコード.getHokenDekidakaTanisu();
        Decimal 費用金額 = Decimal.ZERO;
        if (サービス種類コード41.equals(サービス種類コード) || サービス種類コード42.equals(サービス種類コード)
                || サービス種類コード44.equals(サービス種類コード) || サービス種類コード45.equals(サービス種類コード)) {
            if (!RString.isNullOrEmpty(保険請求額) && !RString.isNullOrEmpty(保険者利用負担額)) {
                費用金額 = new Decimal(保険請求額.toString()).add(new Decimal(保険者利用負担額.toString()));
            }
        } else if (サービス種類コード43.equals(サービス種類コード) || サービス種類コード46.equals(サービス種類コード)) {
            if (!RString.isNullOrEmpty(保険請求額)) {
                費用金額 = new Decimal(保険請求額.toString());
            }
        } else if (サービス種類コード59.equals(サービス種類コード)) {
            if (被保険者番号.equals(レコード.getHiHokenshaNo()) && サービス提供年月.equals(レコード.getServiceTeikyoYM())
                    && 要介護状態区分コード.equals(レコード.getYoKaigoJotaiKubunCode())) {
                費用総額59 = 費用総額59.add(new Decimal(レコード.getHiyosogaku().toString()));
            } else {
                費用金額 = 費用総額59;
                費用総額59 = Decimal.ZERO;
            }
        } else {
            if (!RString.isNullOrEmpty(保険単位数) && !RString.isNullOrEmpty(保険単位単価数) && !RString.isNullOrEmpty(保険出来高点数)) {
                費用金額 = ((new Decimal(保険単位数.toString()).multiply(new Decimal(保険単位単価数.toString())))
                        .add(費用金額).add(new Decimal(保険出来高点数.toString()).multiply(計算用十))).roundDownTo(0);
            }
        }
        return 費用金額;
    }

    private List<List<ShukeinaiyouEntity>> updatecreatentitylist(List<List<ShukeinaiyouEntity>> shukeinaiyouEntityList,
            KyufujissekiTempTblEntity レコード,
            int 人数,
            Decimal 費用総額,
            RString 所得段階,
            RString 要介護状態区分コード
    ) {
        for (List<ShukeinaiyouEntity> list : shukeinaiyouEntityList) {
            for (ShukeinaiyouEntity shukeinaiyouEntity : list) {
                if (所得段階.equals(shukeinaiyouEntity.get所得段階())
                        && !RString.isNullOrEmpty(要介護状態区分コード) && 要介護状態区分コード.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                    shukeinaiyouEntity.setページNo(レコード.getServiceBunrui());
                    if (人数 <= 2) {
                        shukeinaiyouEntity.set人数(shukeinaiyouEntity.get人数() + 1);
                    }
                    shukeinaiyouEntity.set費用総額(shukeinaiyouEntity.get費用総額().add(費用総額));
                }
            }
        }
        return shukeinaiyouEntityList;
    }

    private List<List<ShukeinaiyouEntity>> createntitylist() {
        List<RString> shotokuList = new ArrayList<>();
        shotokuList.add(所得段階_1);
        shotokuList.add(所得段階_2);
        shotokuList.add(所得段階_3);
        shotokuList.add(所得段階_4);
        shotokuList.add(所得段階_5);
        shotokuList.add(所得段階_6);
        shotokuList.add(所得段階_7);
        shotokuList.add(所得段階_8);
        shotokuList.add(所得段階_9);
        shotokuList.add(所得段階_10以上);
        shotokuList.add(所得段階_その他);
        shotokuList.add(所得段階_号);
        shotokuList.add(所得段階_合計);
        List<List<ShukeinaiyouEntity>> entitylist = new ArrayList<>();
        for (int i = 0; i < shotokuList.size(); i++) {
            List<ShukeinaiyouEntity> 所得段階別集計list = new ArrayList<>();
            ShukeinaiyouEntity 要介護度別集計1 = new ShukeinaiyouEntity();
            要介護度別集計1.setページNo(RString.EMPTY);
            要介護度別集計1.set費用総額(Decimal.ZERO);
            要介護度別集計1.set人数(0);
            要介護度別集計1.set所得段階(shotokuList.get(i));
            要介護度別集計1.set要介護状態区分コード(要介護状態区分コード12);
            所得段階別集計list.add(要介護度別集計1);
            ShukeinaiyouEntity 要介護度別集計2 = new ShukeinaiyouEntity();
            要介護度別集計2.setページNo(RString.EMPTY);
            要介護度別集計2.set費用総額(Decimal.ZERO);
            要介護度別集計2.set人数(0);
            要介護度別集計2.set所得段階(shotokuList.get(i));
            要介護度別集計2.set要介護状態区分コード(要介護状態区分コード13);
            所得段階別集計list.add(要介護度別集計2);
            ShukeinaiyouEntity 要介護度別集計3 = new ShukeinaiyouEntity();
            要介護度別集計3.setページNo(RString.EMPTY);
            要介護度別集計3.set費用総額(Decimal.ZERO);
            要介護度別集計3.set人数(0);
            要介護度別集計3.set所得段階(shotokuList.get(i));
            要介護度別集計3.set要介護状態区分コード(要介護状態区分コード11);
            所得段階別集計list.add(要介護度別集計3);
            ShukeinaiyouEntity 要介護度別集計4 = new ShukeinaiyouEntity();
            要介護度別集計4.setページNo(RString.EMPTY);
            要介護度別集計4.set費用総額(Decimal.ZERO);
            要介護度別集計4.set人数(0);
            要介護度別集計4.set所得段階(shotokuList.get(i));
            要介護度別集計4.set要介護状態区分コード(要介護状態区分コード21);
            所得段階別集計list.add(要介護度別集計4);
            ShukeinaiyouEntity 要介護度別集計5 = new ShukeinaiyouEntity();
            要介護度別集計5.setページNo(RString.EMPTY);
            要介護度別集計5.set費用総額(Decimal.ZERO);
            要介護度別集計5.set人数(0);
            要介護度別集計5.set所得段階(shotokuList.get(i));
            要介護度別集計5.set要介護状態区分コード(要介護状態区分コード22);
            所得段階別集計list.add(要介護度別集計5);
            ShukeinaiyouEntity 要介護度別集計6 = new ShukeinaiyouEntity();
            要介護度別集計6.setページNo(RString.EMPTY);
            要介護度別集計6.set費用総額(Decimal.ZERO);
            要介護度別集計6.set人数(0);
            要介護度別集計6.set所得段階(shotokuList.get(i));
            要介護度別集計6.set要介護状態区分コード(要介護状態区分コード23);
            所得段階別集計list.add(要介護度別集計6);
            ShukeinaiyouEntity 要介護度別集計7 = new ShukeinaiyouEntity();
            要介護度別集計7.setページNo(RString.EMPTY);
            要介護度別集計7.set費用総額(Decimal.ZERO);
            要介護度別集計7.set人数(0);
            要介護度別集計7.set所得段階(shotokuList.get(i));
            要介護度別集計7.set要介護状態区分コード(要介護状態区分コード24);
            所得段階別集計list.add(要介護度別集計7);
            ShukeinaiyouEntity 要介護度別集計8 = new ShukeinaiyouEntity();
            要介護度別集計8.setページNo(RString.EMPTY);
            要介護度別集計8.set費用総額(Decimal.ZERO);
            要介護度別集計8.set人数(0);
            要介護度別集計8.set所得段階(shotokuList.get(i));
            要介護度別集計8.set要介護状態区分コード(要介護状態区分コード25);
            所得段階別集計list.add(要介護度別集計8);
            entitylist.add(所得段階別集計list);
        }
        return entitylist;
    }

    private void updateDB出力出力用一時TBL(List<List<ShukeinaiyouEntity>> shukeinaiyouEntityList, IHekinRiyoGakuTokehyoMapper mapper) {
        for (List<ShukeinaiyouEntity> list : shukeinaiyouEntityList) {
            for (ShukeinaiyouEntity shukeinaiyouEntity : list) {
                if (0 < shukeinaiyouEntity.get人数()) {
                    shukeinaiyouEntity.set集計内容(人);
                    if (要介護状態区分コード11.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                        shukeinaiyouEntity.setIskeikanoyokaigo(true);
                        shukeinaiyouEntity.setIsyokaigo1(false);
                        shukeinaiyouEntity.setIsyokaigo2(false);
                        shukeinaiyouEntity.setIsyokaigo3(false);
                        shukeinaiyouEntity.setIsyokaigo4(false);
                        shukeinaiyouEntity.setIsyokaigo5(false);
                        shukeinaiyouEntity.setIsyoshien1(false);
                        shukeinaiyouEntity.setIsyoshien2(false);
                        mapper.updateDB出力出力用一時TBL人数(shukeinaiyouEntity);
                        mapper.updateDB出力出力用一時TBL人数(getShukeinaiyouEntity(shukeinaiyouEntity));
                    } else if (要介護状態区分コード12.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                        shukeinaiyouEntity.setIskeikanoyokaigo(false);
                        shukeinaiyouEntity.setIsyokaigo1(false);
                        shukeinaiyouEntity.setIsyokaigo2(false);
                        shukeinaiyouEntity.setIsyokaigo3(false);
                        shukeinaiyouEntity.setIsyokaigo4(false);
                        shukeinaiyouEntity.setIsyokaigo5(false);
                        shukeinaiyouEntity.setIsyoshien1(true);
                        shukeinaiyouEntity.setIsyoshien2(false);
                        mapper.updateDB出力出力用一時TBL人数(shukeinaiyouEntity);
                        mapper.updateDB出力出力用一時TBL人数(getShukeinaiyouEntity(shukeinaiyouEntity));
                    } else if (要介護状態区分コード13.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                        shukeinaiyouEntity.setIskeikanoyokaigo(false);
                        shukeinaiyouEntity.setIsyokaigo1(false);
                        shukeinaiyouEntity.setIsyokaigo2(false);
                        shukeinaiyouEntity.setIsyokaigo3(false);
                        shukeinaiyouEntity.setIsyokaigo4(false);
                        shukeinaiyouEntity.setIsyokaigo5(false);
                        shukeinaiyouEntity.setIsyoshien1(false);
                        shukeinaiyouEntity.setIsyoshien2(true);
                        mapper.updateDB出力出力用一時TBL人数(shukeinaiyouEntity);
                        mapper.updateDB出力出力用一時TBL人数(getShukeinaiyouEntity(shukeinaiyouEntity));

                    } else if (要介護状態区分コード21.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                        shukeinaiyouEntity.setIskeikanoyokaigo(false);
                        shukeinaiyouEntity.setIsyokaigo1(true);
                        shukeinaiyouEntity.setIsyokaigo2(false);
                        shukeinaiyouEntity.setIsyokaigo3(false);
                        shukeinaiyouEntity.setIsyokaigo4(false);
                        shukeinaiyouEntity.setIsyokaigo5(false);
                        shukeinaiyouEntity.setIsyoshien1(false);
                        shukeinaiyouEntity.setIsyoshien2(false);
                        mapper.updateDB出力出力用一時TBL人数(shukeinaiyouEntity);
                        mapper.updateDB出力出力用一時TBL人数(getShukeinaiyouEntity(shukeinaiyouEntity));
                    } else if (要介護状態区分コード22.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                        shukeinaiyouEntity.setIskeikanoyokaigo(false);
                        shukeinaiyouEntity.setIsyokaigo1(false);
                        shukeinaiyouEntity.setIsyokaigo2(true);
                        shukeinaiyouEntity.setIsyokaigo3(false);
                        shukeinaiyouEntity.setIsyokaigo4(false);
                        shukeinaiyouEntity.setIsyokaigo5(false);
                        shukeinaiyouEntity.setIsyoshien1(false);
                        shukeinaiyouEntity.setIsyoshien2(false);
                        mapper.updateDB出力出力用一時TBL人数(shukeinaiyouEntity);
                        mapper.updateDB出力出力用一時TBL人数(getShukeinaiyouEntity(shukeinaiyouEntity));
                    } else if (要介護状態区分コード23.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                        shukeinaiyouEntity.setIskeikanoyokaigo(false);
                        shukeinaiyouEntity.setIsyokaigo1(false);
                        shukeinaiyouEntity.setIsyokaigo2(false);
                        shukeinaiyouEntity.setIsyokaigo3(true);
                        shukeinaiyouEntity.setIsyokaigo4(false);
                        shukeinaiyouEntity.setIsyokaigo5(false);
                        shukeinaiyouEntity.setIsyoshien1(false);
                        shukeinaiyouEntity.setIsyoshien2(false);
                        mapper.updateDB出力出力用一時TBL人数(shukeinaiyouEntity);
                        mapper.updateDB出力出力用一時TBL人数(getShukeinaiyouEntity(shukeinaiyouEntity));
                    } else if (要介護状態区分コード24.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                        shukeinaiyouEntity.setIskeikanoyokaigo(false);
                        shukeinaiyouEntity.setIsyokaigo1(false);
                        shukeinaiyouEntity.setIsyokaigo2(false);
                        shukeinaiyouEntity.setIsyokaigo3(false);
                        shukeinaiyouEntity.setIsyokaigo4(true);
                        shukeinaiyouEntity.setIsyokaigo5(false);
                        shukeinaiyouEntity.setIsyoshien1(false);
                        shukeinaiyouEntity.setIsyoshien2(false);
                        mapper.updateDB出力出力用一時TBL人数(shukeinaiyouEntity);
                        mapper.updateDB出力出力用一時TBL人数(getShukeinaiyouEntity(shukeinaiyouEntity));
                    } else if (要介護状態区分コード25.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                        shukeinaiyouEntity.setIskeikanoyokaigo(false);
                        shukeinaiyouEntity.setIsyokaigo1(false);
                        shukeinaiyouEntity.setIsyokaigo2(false);
                        shukeinaiyouEntity.setIsyokaigo3(false);
                        shukeinaiyouEntity.setIsyokaigo4(false);
                        shukeinaiyouEntity.setIsyokaigo5(true);
                        shukeinaiyouEntity.setIsyoshien1(false);
                        shukeinaiyouEntity.setIsyoshien2(false);
                        mapper.updateDB出力出力用一時TBL人数(shukeinaiyouEntity);
                        mapper.updateDB出力出力用一時TBL人数(getShukeinaiyouEntity(shukeinaiyouEntity));
                    }
                    getupdateDB出力出力用一時TB(
                            mapper, shukeinaiyouEntity);
                }

            }
        }
    }

    private ShukeinaiyouEntity getShukeinaiyouEntity(ShukeinaiyouEntity shukeinaiyouEntity) {
        ShukeinaiyouEntity newShukeinaiyouEntity = new ShukeinaiyouEntity();
        newShukeinaiyouEntity.setページNo(総合計_ページ);
        newShukeinaiyouEntity.set人数(shukeinaiyouEntity.get人数());
        newShukeinaiyouEntity.set所得段階(shukeinaiyouEntity.get所得段階());
        newShukeinaiyouEntity.set要介護状態区分コード(shukeinaiyouEntity.get要介護状態区分コード());
        newShukeinaiyouEntity.set集計内容(shukeinaiyouEntity.get集計内容());
        newShukeinaiyouEntity.set費用総額(shukeinaiyouEntity.get費用総額());
        newShukeinaiyouEntity.setIskeikanoyokaigo(shukeinaiyouEntity.isIskeikanoyokaigo());
        newShukeinaiyouEntity.setIsyokaigo1(shukeinaiyouEntity.isIsyokaigo1());
        newShukeinaiyouEntity.setIsyokaigo2(shukeinaiyouEntity.isIsyokaigo2());
        newShukeinaiyouEntity.setIsyokaigo3(shukeinaiyouEntity.isIsyokaigo3());
        newShukeinaiyouEntity.setIsyokaigo4(shukeinaiyouEntity.isIsyokaigo4());
        newShukeinaiyouEntity.setIsyokaigo5(shukeinaiyouEntity.isIsyokaigo5());
        newShukeinaiyouEntity.setIsyoshien1(shukeinaiyouEntity.isIsyoshien1());
        newShukeinaiyouEntity.setIsyoshien2(shukeinaiyouEntity.isIsyoshien2());
        return newShukeinaiyouEntity;
    }

    private void getupdateDB出力出力用一時TB(
            IHekinRiyoGakuTokehyoMapper mapper, ShukeinaiyouEntity shukeinaiyouEntity) {
        if (Decimal.ZERO.compareTo(shukeinaiyouEntity.get費用総額()) < 0) {
            shukeinaiyouEntity.set集計内容(費用総額);
            if (要介護状態区分コード11.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                shukeinaiyouEntity.setIskeikanoyokaigo(true);
                shukeinaiyouEntity.setIsyokaigo1(false);
                shukeinaiyouEntity.setIsyokaigo2(false);
                shukeinaiyouEntity.setIsyokaigo3(false);
                shukeinaiyouEntity.setIsyokaigo4(false);
                shukeinaiyouEntity.setIsyokaigo5(false);
                shukeinaiyouEntity.setIsyoshien1(false);
                shukeinaiyouEntity.setIsyoshien2(false);
                mapper.updateDB出力出力用一時TBL費用総額(shukeinaiyouEntity);
                mapper.updateDB出力出力用一時TBL費用総額(getShukeinaiyouEntity(shukeinaiyouEntity));
            } else if (要介護状態区分コード12.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                shukeinaiyouEntity.setIskeikanoyokaigo(false);
                shukeinaiyouEntity.setIsyokaigo1(false);
                shukeinaiyouEntity.setIsyokaigo2(false);
                shukeinaiyouEntity.setIsyokaigo3(false);
                shukeinaiyouEntity.setIsyokaigo4(false);
                shukeinaiyouEntity.setIsyokaigo5(false);
                shukeinaiyouEntity.setIsyoshien1(true);
                shukeinaiyouEntity.setIsyoshien2(false);
                mapper.updateDB出力出力用一時TBL費用総額(shukeinaiyouEntity);
                mapper.updateDB出力出力用一時TBL費用総額(getShukeinaiyouEntity(shukeinaiyouEntity));
            } else if (要介護状態区分コード13.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                shukeinaiyouEntity.setIskeikanoyokaigo(false);
                shukeinaiyouEntity.setIsyokaigo1(false);
                shukeinaiyouEntity.setIsyokaigo2(false);
                shukeinaiyouEntity.setIsyokaigo3(false);
                shukeinaiyouEntity.setIsyokaigo4(false);
                shukeinaiyouEntity.setIsyokaigo5(false);
                shukeinaiyouEntity.setIsyoshien1(false);
                shukeinaiyouEntity.setIsyoshien2(true);
                mapper.updateDB出力出力用一時TBL費用総額(shukeinaiyouEntity);
                mapper.updateDB出力出力用一時TBL費用総額(getShukeinaiyouEntity(shukeinaiyouEntity));
            } else if (要介護状態区分コード21.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                shukeinaiyouEntity.setIskeikanoyokaigo(false);
                shukeinaiyouEntity.setIsyokaigo1(true);
                shukeinaiyouEntity.setIsyokaigo2(false);
                shukeinaiyouEntity.setIsyokaigo3(false);
                shukeinaiyouEntity.setIsyokaigo4(false);
                shukeinaiyouEntity.setIsyokaigo5(false);
                shukeinaiyouEntity.setIsyoshien1(false);
                shukeinaiyouEntity.setIsyoshien2(false);
                mapper.updateDB出力出力用一時TBL費用総額(shukeinaiyouEntity);
                mapper.updateDB出力出力用一時TBL費用総額(getShukeinaiyouEntity(shukeinaiyouEntity));
            } else if (要介護状態区分コード22.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                shukeinaiyouEntity.setIskeikanoyokaigo(false);
                shukeinaiyouEntity.setIsyokaigo1(false);
                shukeinaiyouEntity.setIsyokaigo2(true);
                shukeinaiyouEntity.setIsyokaigo3(false);
                shukeinaiyouEntity.setIsyokaigo4(false);
                shukeinaiyouEntity.setIsyokaigo5(false);
                shukeinaiyouEntity.setIsyoshien1(false);
                shukeinaiyouEntity.setIsyoshien2(false);
                mapper.updateDB出力出力用一時TBL費用総額(shukeinaiyouEntity);
                mapper.updateDB出力出力用一時TBL費用総額(getShukeinaiyouEntity(shukeinaiyouEntity));
            } else if (要介護状態区分コード23.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                shukeinaiyouEntity.setIskeikanoyokaigo(false);
                shukeinaiyouEntity.setIsyokaigo1(false);
                shukeinaiyouEntity.setIsyokaigo2(false);
                shukeinaiyouEntity.setIsyokaigo3(true);
                shukeinaiyouEntity.setIsyokaigo4(false);
                shukeinaiyouEntity.setIsyokaigo5(false);
                shukeinaiyouEntity.setIsyoshien1(false);
                shukeinaiyouEntity.setIsyoshien2(false);
                mapper.updateDB出力出力用一時TBL費用総額(shukeinaiyouEntity);
                mapper.updateDB出力出力用一時TBL費用総額(getShukeinaiyouEntity(shukeinaiyouEntity));
            } else if (要介護状態区分コード24.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                shukeinaiyouEntity.setIskeikanoyokaigo(false);
                shukeinaiyouEntity.setIsyokaigo1(false);
                shukeinaiyouEntity.setIsyokaigo2(false);
                shukeinaiyouEntity.setIsyokaigo3(false);
                shukeinaiyouEntity.setIsyokaigo4(true);
                shukeinaiyouEntity.setIsyokaigo5(false);
                shukeinaiyouEntity.setIsyoshien1(false);
                shukeinaiyouEntity.setIsyoshien2(false);
                mapper.updateDB出力出力用一時TBL費用総額(shukeinaiyouEntity);
                mapper.updateDB出力出力用一時TBL費用総額(getShukeinaiyouEntity(shukeinaiyouEntity));
            } else if (要介護状態区分コード25.equals(shukeinaiyouEntity.get要介護状態区分コード())) {
                shukeinaiyouEntity.setIskeikanoyokaigo(false);
                shukeinaiyouEntity.setIsyokaigo1(false);
                shukeinaiyouEntity.setIsyokaigo2(false);
                shukeinaiyouEntity.setIsyokaigo3(false);
                shukeinaiyouEntity.setIsyokaigo4(false);
                shukeinaiyouEntity.setIsyokaigo5(true);
                shukeinaiyouEntity.setIsyoshien1(false);
                shukeinaiyouEntity.setIsyoshien2(false);
                mapper.updateDB出力出力用一時TBL費用総額(shukeinaiyouEntity);
                mapper.updateDB出力出力用一時TBL費用総額(getShukeinaiyouEntity(shukeinaiyouEntity));
            }
        }
    }
}
