/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_EditPattern;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyotokeihyo.RiyoJokyoTokeihyoServiceShuruiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyotokeihyo.RiyoJokyoTokeihyoShukeiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 利用状況統計表（明細リスト）統計表作成作成サービスクラスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiService {

    private static final int 数字_7 = 7;
    private static final int 数字_5 = 5;
    private static final int 数字_4 = 4;
    private static final int 数字_3 = 3;
    private static final int 数字_2 = 2;
    private static final int 数字_0 = 0;
    private final Map<RString, RiyoJokyoTokeihyoShukeiKekkaEntity> 利用状況統計表集計結果Map;

    /**
     * コンストラクタです。
     *
     * @param 利用状況統計表集計結果Map 利用状況統計表集計結果Map
     */
    public RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiService(Map<RString, RiyoJokyoTokeihyoShukeiKekkaEntity> 利用状況統計表集計結果Map) {
        this.利用状況統計表集計結果Map = 利用状況統計表集計結果Map;
    }

    /**
     * createInstanceのメソドです。
     *
     * @return 利用状況統計表（明細リスト）作成サービスクラス
     */
    public static RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiService createInstance() {
        return InstanceProvider.create(RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiService.class);
    }

    /**
     * 利用実人員を取得します
     *
     * @param entity 処理対象データEntity
     * @param 統計用サービス種類 統計用サービス種類
     */
    public void get利用実人員(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {

        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (!利用状況統計表集計結果Map.containsKey(統計用サービス種類)) {
            return;
        }
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (リスト_サービス種類集計 == null) {
            リスト_サービス種類集計 = new ArrayList<>();
            RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計entity;
            for (int i = 0; i < 数字_7; i++) {
                集計entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
                集計entity.setサービス種類コード(tokeihyo_EditPattern.getコード());
                リスト_サービス種類集計.add(集計entity);
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(リスト_サービス種類集計);
        }

        if (YoKaigoJotaiKubun.非該当.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create非該当(統計用サービス種類, tokeihyo_EditPattern);
        } else if (YoKaigoJotaiKubun.要支援1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create要支援1(統計用サービス種類, tokeihyo_EditPattern);
        } else if (YoKaigoJotaiKubun.要支援2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create要支援2(統計用サービス種類, tokeihyo_EditPattern);
        } else if (YoKaigoJotaiKubun.要支援_経過的要介護.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create要支援経過的要介護(統計用サービス種類, tokeihyo_EditPattern);
        } else if (YoKaigoJotaiKubun.要介護1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create要介護1(統計用サービス種類, tokeihyo_EditPattern);
        } else if (YoKaigoJotaiKubun.要介護2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create要介護2(統計用サービス種類, tokeihyo_EditPattern);
        } else if (YoKaigoJotaiKubun.要介護3.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create要介護3(統計用サービス種類, tokeihyo_EditPattern);
        } else if (YoKaigoJotaiKubun.要介護4.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create要介護4(統計用サービス種類, tokeihyo_EditPattern);
        } else if (YoKaigoJotaiKubun.要介護5.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create要介護5(統計用サービス種類, tokeihyo_EditPattern);
        }
    }

    private void create非該当(RString 統計用サービス種類, RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern) {
        create集計項目1_1(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目1_1(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目1_1(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目1_1(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目1_1(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード());
        }
    }

    private void create要支援1(RString 統計用サービス種類, RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern) {
        create集計項目1_2(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目1_2(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目1_2(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目1_2(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目1_2(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード());
        }
    }

    private void create要支援2(RString 統計用サービス種類, RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern) {
        create集計項目1_3(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目1_3(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目1_3(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目1_3(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目1_3(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード());
        }
    }

    private void create要支援経過的要介護(RString 統計用サービス種類, RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern) {
        create集計項目1_4(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目1_4(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目1_4(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目1_4(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目1_4(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード());
        }
    }

    private void create要介護1(RString 統計用サービス種類, RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern) {
        create集計項目1_5(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目1_5(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目1_5(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目1_5(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目1_5(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード());
        }
    }

    private void create要介護2(RString 統計用サービス種類, RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern) {
        create集計項目1_6(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目1_6(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目1_6(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目1_6(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目1_6(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード());
        }
    }

    private void create要介護3(RString 統計用サービス種類, RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern) {
        create集計項目1_7(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目1_7(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目1_7(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目1_7(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目1_7(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード());
        }
    }

    private void create要介護4(RString 統計用サービス種類, RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern) {
        create集計項目1_8(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目1_8(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目1_8(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目1_8(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目1_8(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード());
        }
    }

    private void create要介護5(RString 統計用サービス種類, RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern) {
        create集計項目1_9(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目1_9(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目1_9(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目1_9(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード());
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目1_9(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード());
        }
    }

    private void create集計項目1_1(RString 統計用サービス種類) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_0);
        if (集計項目Entity.get集計項目1_1() == null) {

            集計項目Entity.set集計項目1_1(Decimal.ONE);
        } else {
            集計項目Entity.set集計項目1_1(nullToZero(集計項目Entity.get集計項目1_1()).add(Decimal.ONE));
        }
        集計項目Entity.set集計項目1_10(nullToZero(集計項目Entity.get集計項目1_10()).add(Decimal.ONE));
    }

    private void create集計項目1_2(RString 統計用サービス種類) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_0);
        if (集計項目Entity.get集計項目1_2() == null) {

            集計項目Entity.set集計項目1_2(Decimal.ONE);
        } else {
            集計項目Entity.set集計項目1_2(nullToZero(集計項目Entity.get集計項目1_2()).add(Decimal.ONE));
        }
        集計項目Entity.set集計項目1_10(nullToZero(集計項目Entity.get集計項目1_10()).add(Decimal.ONE));
    }

    private void create集計項目1_3(RString 統計用サービス種類) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_0);
        if (集計項目Entity.get集計項目1_3() == null) {

            集計項目Entity.set集計項目1_3(Decimal.ONE);
        } else {
            集計項目Entity.set集計項目1_3(nullToZero(集計項目Entity.get集計項目1_3()).add(Decimal.ONE));
        }
        集計項目Entity.set集計項目1_10(nullToZero(集計項目Entity.get集計項目1_10()).add(Decimal.ONE));
    }

    private void create集計項目1_4(RString 統計用サービス種類) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_0);
        if (集計項目Entity.get集計項目1_4() == null) {

            集計項目Entity.set集計項目1_4(Decimal.ONE);
        } else {
            集計項目Entity.set集計項目1_4(集計項目Entity.get集計項目1_4().add(Decimal.ONE));
        }
        集計項目Entity.set集計項目1_10(nullToZero(集計項目Entity.get集計項目1_10()).add(Decimal.ONE));
    }

    private void create集計項目1_5(RString 統計用サービス種類) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_0);
        if (集計項目Entity.get集計項目1_5() == null) {

            集計項目Entity.set集計項目1_5(Decimal.ONE);
        } else {
            集計項目Entity.set集計項目1_5(集計項目Entity.get集計項目1_5().add(Decimal.ONE));
        }
        集計項目Entity.set集計項目1_10(nullToZero(集計項目Entity.get集計項目1_10()).add(Decimal.ONE));
    }

    private void create集計項目1_6(RString 統計用サービス種類) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_0);
        if (集計項目Entity.get集計項目1_6() == null) {

            集計項目Entity.set集計項目1_6(Decimal.ONE);
        } else {
            集計項目Entity.set集計項目1_6(集計項目Entity.get集計項目1_6().add(Decimal.ONE));
        }
        集計項目Entity.set集計項目1_10(nullToZero(集計項目Entity.get集計項目1_10()).add(Decimal.ONE));
    }

    private void create集計項目1_7(RString 統計用サービス種類) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_0);
        if (集計項目Entity.get集計項目1_7() == null) {

            集計項目Entity.set集計項目1_7(Decimal.ONE);
        } else {
            集計項目Entity.set集計項目1_7(集計項目Entity.get集計項目1_7().add(Decimal.ONE));
        }
        集計項目Entity.set集計項目1_10(nullToZero(集計項目Entity.get集計項目1_10()).add(Decimal.ONE));
    }

    private void create集計項目1_8(RString 統計用サービス種類) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_0);
        if (集計項目Entity.get集計項目1_8() == null) {

            集計項目Entity.set集計項目1_8(Decimal.ONE);
        } else {
            集計項目Entity.set集計項目1_8(集計項目Entity.get集計項目1_8().add(Decimal.ONE));
        }
        集計項目Entity.set集計項目1_10(nullToZero(集計項目Entity.get集計項目1_10()).add(Decimal.ONE));
    }

    private void create集計項目1_9(RString 統計用サービス種類) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_0);
        if (集計項目Entity.get集計項目1_9() == null) {

            集計項目Entity.set集計項目1_9(Decimal.ONE);
        } else {
            集計項目Entity.set集計項目1_9(集計項目Entity.get集計項目1_9().add(Decimal.ONE));
        }
        集計項目Entity.set集計項目1_10(nullToZero(集計項目Entity.get集計項目1_10()).add(Decimal.ONE));
    }

    /**
     * 単位数を作成します
     *
     * @param entity 処理対象データEntity
     * @param 統計用サービス種類 統計用サービス種類
     */
    public void get単位数(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (!利用状況統計表集計結果Map.containsKey(統計用サービス種類)) {
            return;
        }
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (リスト_サービス種類集計 == null) {
            リスト_サービス種類集計 = new ArrayList<>();
            RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計entity;
            for (int i = 0; i < 数字_7; i++) {
                集計entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
                集計entity.setサービス種類コード(tokeihyo_EditPattern.getコード());
                リスト_サービス種類集計.add(集計entity);
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(リスト_サービス種類集計);
        }
        if (!tokeihyo_EditPattern.is単位数集計有無()) {
            return;
        }
        Decimal 加算対象 = new Decimal(entity.getHokenTanisu().toString())
                .add(new Decimal(entity.getHokenDekidakaTanisu().toString()));
        if (YoKaigoJotaiKubun.非該当.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目単位数3_1(統計用サービス種類, 加算対象);
        } else if (YoKaigoJotaiKubun.要支援1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目単位数3_2(統計用サービス種類, 加算対象);
        } else if (YoKaigoJotaiKubun.要支援2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目単位数3_3(統計用サービス種類, 加算対象);
        } else if (YoKaigoJotaiKubun.要支援_経過的要介護.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目単位数3_4(統計用サービス種類, 加算対象);
        } else if (YoKaigoJotaiKubun.要介護1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目単位数3_5(統計用サービス種類, 加算対象);
        } else if (YoKaigoJotaiKubun.要介護2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目単位数3_6(統計用サービス種類, 加算対象);
        } else if (YoKaigoJotaiKubun.要介護3.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目単位数3_7(統計用サービス種類, 加算対象);
        } else if (YoKaigoJotaiKubun.要介護4.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目単位数3_8(統計用サービス種類, 加算対象);
        } else if (YoKaigoJotaiKubun.要介護5.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目単位数3_9(統計用サービス種類, 加算対象);
        }
    }

    private void create集計項目3_1(RString 統計用サービス種類, Decimal 加算対象) {

        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_2);
        if (集計項目Entity.get集計項目3_1() == null) {

            集計項目Entity.set集計項目3_1(加算対象);
        } else {
            集計項目Entity.set集計項目3_1(集計項目Entity.get集計項目3_1().add(加算対象));
        }
        集計項目Entity.set集計項目3_10(nullToZero(集計項目Entity.get集計項目3_10()).add(加算対象));
    }

    private void create集計項目単位数3_1(RString 統計用サービス種類, Decimal 加算対象) {

        create集計項目3_1(統計用サービス種類, 加算対象);
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目3_1(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目3_1(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目3_1(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目3_1(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目3_2(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_2);
        if (集計項目Entity.get集計項目3_2() == null) {

            集計項目Entity.set集計項目3_2(加算対象);
        } else {
            集計項目Entity.set集計項目3_2(集計項目Entity.get集計項目3_2().add(加算対象));
        }
        集計項目Entity.set集計項目3_10(nullToZero(集計項目Entity.get集計項目3_10()).add(加算対象));
    }

    private void create集計項目単位数3_2(RString 統計用サービス種類, Decimal 加算対象) {
        create集計項目3_2(統計用サービス種類, 加算対象);
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目3_2(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目3_2(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目3_2(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目3_2(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目3_3(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_2);
        if (集計項目Entity.get集計項目3_3() == null) {

            集計項目Entity.set集計項目3_3(加算対象);
        } else {
            集計項目Entity.set集計項目3_3(集計項目Entity.get集計項目3_3().add(加算対象));
        }
        集計項目Entity.set集計項目3_10(nullToZero(集計項目Entity.get集計項目3_10()).add(加算対象));
    }

    private void create集計項目単位数3_3(RString 統計用サービス種類, Decimal 加算対象) {
        create集計項目3_3(統計用サービス種類, 加算対象);
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目3_3(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目3_3(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目3_3(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目3_3(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目3_4(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_2);
        if (集計項目Entity.get集計項目3_4() == null) {

            集計項目Entity.set集計項目3_4(加算対象);
        } else {
            集計項目Entity.set集計項目3_4(集計項目Entity.get集計項目3_4().add(加算対象));
        }
        集計項目Entity.set集計項目3_10(nullToZero(集計項目Entity.get集計項目3_10()).add(加算対象));
    }

    private void create集計項目単位数3_4(RString 統計用サービス種類, Decimal 加算対象) {
        create集計項目3_4(統計用サービス種類, 加算対象);
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目3_4(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目3_4(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目3_4(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目3_4(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目3_5(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_2);
        if (集計項目Entity.get集計項目3_5() == null) {

            集計項目Entity.set集計項目3_5(加算対象);
        } else {
            集計項目Entity.set集計項目3_5(集計項目Entity.get集計項目3_5().add(加算対象));
        }
        集計項目Entity.set集計項目3_10(nullToZero(集計項目Entity.get集計項目3_10()).add(加算対象));
    }

    private void create集計項目単位数3_5(RString 統計用サービス種類, Decimal 加算対象) {
        create集計項目3_5(統計用サービス種類, 加算対象);
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目3_5(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目3_5(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目3_5(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目3_5(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目3_6(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_2);
        if (集計項目Entity.get集計項目3_6() == null) {

            集計項目Entity.set集計項目3_6(加算対象);
        } else {
            集計項目Entity.set集計項目3_6(集計項目Entity.get集計項目3_6().add(加算対象));
        }
        集計項目Entity.set集計項目3_10(nullToZero(集計項目Entity.get集計項目3_10()).add(加算対象));
    }

    private void create集計項目単位数3_6(RString 統計用サービス種類, Decimal 加算対象) {
        create集計項目3_6(統計用サービス種類, 加算対象);
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目3_6(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目3_6(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目3_6(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目3_6(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目3_7(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_2);
        if (集計項目Entity.get集計項目3_7() == null) {

            集計項目Entity.set集計項目3_7(加算対象);
        } else {
            集計項目Entity.set集計項目3_7(集計項目Entity.get集計項目3_7().add(加算対象));
        }
        集計項目Entity.set集計項目3_10(nullToZero(集計項目Entity.get集計項目3_10()).add(加算対象));
    }

    private void create集計項目単位数3_7(RString 統計用サービス種類, Decimal 加算対象) {
        create集計項目3_7(統計用サービス種類, 加算対象);
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目3_7(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目3_7(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目3_7(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目3_7(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目3_8(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_2);
        if (集計項目Entity.get集計項目3_8() == null) {

            集計項目Entity.set集計項目3_8(加算対象);
        } else {
            集計項目Entity.set集計項目3_8(集計項目Entity.get集計項目3_8().add(加算対象));
        }
        集計項目Entity.set集計項目3_10(nullToZero(集計項目Entity.get集計項目3_10()).add(加算対象));
    }

    private void create集計項目単位数3_8(RString 統計用サービス種類, Decimal 加算対象) {
        create集計項目3_8(統計用サービス種類, 加算対象);
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目3_8(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目3_8(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目3_8(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目3_8(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目3_9(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_2);
        if (集計項目Entity.get集計項目3_9() == null) {

            集計項目Entity.set集計項目3_9(加算対象);
        } else {
            集計項目Entity.set集計項目3_9(集計項目Entity.get集計項目3_9().add(加算対象));
        }
        集計項目Entity.set集計項目3_10(nullToZero(集計項目Entity.get集計項目3_10()).add(加算対象));
    }

    private void create集計項目単位数3_9(RString 統計用サービス種類, Decimal 加算対象) {
        create集計項目3_9(統計用サービス種類, 加算対象);
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目3_9(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目3_9(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目3_9(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目3_9(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    /**
     * 費用総額を作成します
     *
     * @param entity 処理対象データEntity
     * @param 統計用サービス種類 統計用サービス種類
     */
    public void get費用総額(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (!利用状況統計表集計結果Map.containsKey(統計用サービス種類)) {
            return;
        }
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (リスト_サービス種類集計 == null) {
            リスト_サービス種類集計 = new ArrayList<>();
            RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計entity;
            for (int i = 0; i < 数字_7; i++) {
                集計entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
                集計entity.setサービス種類コード(tokeihyo_EditPattern.getコード());
                リスト_サービス種類集計.add(集計entity);
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(リスト_サービス種類集計);
        }
        if (!tokeihyo_EditPattern.is単位数集計有無()) {
            return;
        }
        RString 費用総額集計パターン = tokeihyo_EditPattern.get費用総額集計パターン().getコード();
        Decimal 集計対象 = Decimal.ZERO;
        if (費用総額集計パターン.equals(new RString("1"))) {
            集計対象 = new Decimal(new Decimal(entity.getHokenTanisu().toString())
                    .multiply(new Decimal(entity.getHokenTanisuTanka().toString()))
                    .intValue()).add(new Decimal(entity.getHokenDekidakaTanisu().toString())
                            .multiply(Decimal.TEN)).add(new Decimal(entity.getShokujiTeikyohiGokei().toString()));
        } else if (費用総額集計パターン.equals(new RString("2"))) {
            集計対象 = new Decimal(entity.getHokenSeikyugaku().toString());
        } else if (費用総額集計パターン.equals(new RString("3"))) {
            集計対象 = new Decimal(entity.getHokenSeikyugaku().toString())
                    .add(new Decimal(entity.getHokenRiyoshaFutangaku().toString()));
        }
        if (YoKaigoJotaiKubun.非該当.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目費用総額4_1(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要支援1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目費用総額4_2(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要支援2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目費用総額4_3(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要支援_経過的要介護.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目費用総額4_4(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目費用総額4_5(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目費用総額4_6(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護3.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目費用総額4_7(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護4.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目費用総額4_8(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護5.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目費用総額4_9(統計用サービス種類, 集計対象);
        }
    }

    private void create集計項目4_1(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_3);
        if (集計項目Entity.get集計項目4_1() == null) {

            集計項目Entity.set集計項目4_1(加算対象);
        } else {
            集計項目Entity.set集計項目4_1(集計項目Entity.get集計項目4_1().add(加算対象));
        }
        集計項目Entity.set集計項目4_10(nullToZero(集計項目Entity.get集計項目4_10()).add(加算対象));
    }

    private void create集計項目費用総額4_1(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目4_1(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目4_1(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目4_1(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目4_1(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目4_1(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目4_2(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_3);
        if (集計項目Entity.get集計項目4_2() == null) {

            集計項目Entity.set集計項目4_2(加算対象);
        } else {
            集計項目Entity.set集計項目4_2(集計項目Entity.get集計項目4_2().add(加算対象));
        }
        集計項目Entity.set集計項目4_10(nullToZero(集計項目Entity.get集計項目4_10()).add(加算対象));
    }

    private void create集計項目費用総額4_2(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目4_2(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目4_2(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目4_2(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目4_2(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目4_2(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目4_3(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_3);
        if (集計項目Entity.get集計項目4_3() == null) {

            集計項目Entity.set集計項目4_3(加算対象);
        } else {
            集計項目Entity.set集計項目4_3(集計項目Entity.get集計項目4_3().add(加算対象));
        }
        集計項目Entity.set集計項目4_10(nullToZero(集計項目Entity.get集計項目4_10()).add(加算対象));
    }

    private void create集計項目費用総額4_3(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目4_3(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目4_3(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目4_3(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目4_3(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目4_3(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目4_4(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_3);
        if (集計項目Entity.get集計項目4_4() == null) {

            集計項目Entity.set集計項目4_4(加算対象);
        } else {
            集計項目Entity.set集計項目4_4(集計項目Entity.get集計項目4_4().add(加算対象));
        }
        集計項目Entity.set集計項目4_10(nullToZero(集計項目Entity.get集計項目4_10()).add(加算対象));
    }

    private void create集計項目費用総額4_4(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目4_4(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目4_4(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目4_4(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目4_4(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目4_4(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目4_5(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_3);
        if (集計項目Entity.get集計項目4_5() == null) {

            集計項目Entity.set集計項目4_5(加算対象);
        } else {
            集計項目Entity.set集計項目4_5(集計項目Entity.get集計項目4_5().add(加算対象));
        }
        集計項目Entity.set集計項目4_10(nullToZero(集計項目Entity.get集計項目4_10()).add(加算対象));
    }

    private void create集計項目費用総額4_5(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目4_5(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目4_5(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目4_5(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目4_5(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目4_5(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目4_6(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_3);
        if (集計項目Entity.get集計項目4_6() == null) {

            集計項目Entity.set集計項目4_6(加算対象);
        } else {
            集計項目Entity.set集計項目4_6(集計項目Entity.get集計項目4_6().add(加算対象));
        }
        集計項目Entity.set集計項目4_10(nullToZero(集計項目Entity.get集計項目4_10()).add(加算対象));
    }

    private void create集計項目費用総額4_6(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目4_6(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目4_6(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目4_6(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目4_6(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目4_6(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目4_7(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_3);
        if (集計項目Entity.get集計項目4_7() == null) {

            集計項目Entity.set集計項目4_7(加算対象);
        } else {
            集計項目Entity.set集計項目4_7(集計項目Entity.get集計項目4_7().add(加算対象));
        }
        集計項目Entity.set集計項目4_10(nullToZero(集計項目Entity.get集計項目4_10()).add(加算対象));
    }

    private void create集計項目費用総額4_7(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目4_7(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目4_7(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目4_7(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目4_7(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目4_7(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目4_8(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_3);
        if (集計項目Entity.get集計項目4_8() == null) {

            集計項目Entity.set集計項目4_8(加算対象);
        } else {
            集計項目Entity.set集計項目4_8(集計項目Entity.get集計項目4_8().add(加算対象));
        }
        集計項目Entity.set集計項目4_10(nullToZero(集計項目Entity.get集計項目4_10()).add(加算対象));
    }

    private void create集計項目費用総額4_8(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目4_8(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目4_8(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目4_8(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目4_8(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目4_8(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目4_9(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_3);
        if (集計項目Entity.get集計項目4_9() == null) {

            集計項目Entity.set集計項目4_9(加算対象);
        } else {
            集計項目Entity.set集計項目4_9(集計項目Entity.get集計項目4_9().add(加算対象));
        }
        集計項目Entity.set集計項目4_10(nullToZero(集計項目Entity.get集計項目4_10()).add(加算対象));
    }

    private void create集計項目費用総額4_9(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目4_9(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目4_9(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目4_9(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目4_9(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目4_9(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    /**
     * 介護給付費を作成します
     *
     * @param entity 処理対象データEntity
     * @param 統計用サービス種類 統計用サービス種類
     */
    public void get介護給付費(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (!利用状況統計表集計結果Map.containsKey(統計用サービス種類)) {
            return;
        }
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (リスト_サービス種類集計 == null) {
            リスト_サービス種類集計 = new ArrayList<>();
            RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計entity;
            for (int i = 0; i < 数字_7; i++) {
                集計entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
                集計entity.setサービス種類コード(tokeihyo_EditPattern.getコード());
                リスト_サービス種類集計.add(集計entity);
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(リスト_サービス種類集計);
        }
        if (!tokeihyo_EditPattern.is介護給付費集計有無()) {
            return;
        }
        Decimal 集計対象 = new Decimal(entity.getHokenSeikyugaku().toString())
                .add(new Decimal(entity.getHokenDekidakaSeikyugaku().toString()))
                .add(new Decimal(entity.getShokujiTeikyohiSeikyugaku().toString()));
        if (YoKaigoJotaiKubun.非該当.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create介護給付費5_1(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要支援1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create介護給付費5_2(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要支援2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create介護給付費5_3(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要支援_経過的要介護.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create介護給付費5_4(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create介護給付費5_5(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create介護給付費5_6(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護3.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create介護給付費5_7(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護4.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create介護給付費5_8(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護5.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create介護給付費5_9(統計用サービス種類, 集計対象);
        }
    }

    private void create集計項目5_1(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_4);
        if (集計項目Entity.get集計項目5_1() == null) {

            集計項目Entity.set集計項目5_1(加算対象);
        } else {
            集計項目Entity.set集計項目5_1(集計項目Entity.get集計項目5_1().add(加算対象));
        }
        集計項目Entity.set集計項目5_10(nullToZero(集計項目Entity.get集計項目5_10()).add(加算対象));
    }

    private void create介護給付費5_1(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目5_1(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目5_1(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目5_1(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目5_1(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目5_1(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目5_2(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_4);
        if (集計項目Entity.get集計項目5_2() == null) {

            集計項目Entity.set集計項目5_2(加算対象);
        } else {
            集計項目Entity.set集計項目5_2(集計項目Entity.get集計項目5_2().add(加算対象));
        }
        集計項目Entity.set集計項目5_10(nullToZero(集計項目Entity.get集計項目5_10()).add(加算対象));
    }

    private void create介護給付費5_2(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目5_2(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目5_2(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目5_2(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目5_2(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目5_2(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目5_3(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_4);
        if (集計項目Entity.get集計項目5_3() == null) {

            集計項目Entity.set集計項目5_3(加算対象);
        } else {
            集計項目Entity.set集計項目5_3(集計項目Entity.get集計項目5_3().add(加算対象));
        }
        集計項目Entity.set集計項目5_10(nullToZero(集計項目Entity.get集計項目5_10()).add(加算対象));
    }

    private void create介護給付費5_3(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目5_3(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目5_3(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目5_3(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目5_3(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目5_3(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目5_4(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_4);
        if (集計項目Entity.get集計項目5_4() == null) {

            集計項目Entity.set集計項目5_4(加算対象);
        } else {
            集計項目Entity.set集計項目5_4(集計項目Entity.get集計項目5_4().add(加算対象));
        }
        集計項目Entity.set集計項目5_10(nullToZero(集計項目Entity.get集計項目5_10()).add(加算対象));
    }

    private void create介護給付費5_4(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目5_4(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目5_4(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目5_4(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目5_4(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目5_4(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目5_5(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_4);
        if (集計項目Entity.get集計項目5_5() == null) {

            集計項目Entity.set集計項目5_5(加算対象);
        } else {
            集計項目Entity.set集計項目5_5(集計項目Entity.get集計項目5_5().add(加算対象));
        }
        集計項目Entity.set集計項目5_10(nullToZero(集計項目Entity.get集計項目5_10()).add(加算対象));
    }

    private void create介護給付費5_5(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目5_5(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目5_5(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目5_5(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目5_5(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目5_5(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目5_6(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_4);
        if (集計項目Entity.get集計項目5_6() == null) {

            集計項目Entity.set集計項目5_6(加算対象);
        } else {
            集計項目Entity.set集計項目5_6(集計項目Entity.get集計項目5_6().add(加算対象));
        }
        集計項目Entity.set集計項目5_10(nullToZero(集計項目Entity.get集計項目5_10()).add(加算対象));
    }

    private void create介護給付費5_6(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目5_6(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目5_6(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目5_6(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目5_6(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目5_6(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目5_7(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_4);
        if (集計項目Entity.get集計項目5_7() == null) {

            集計項目Entity.set集計項目5_7(加算対象);
        } else {
            集計項目Entity.set集計項目5_7(集計項目Entity.get集計項目5_7().add(加算対象));
        }
        集計項目Entity.set集計項目5_10(nullToZero(集計項目Entity.get集計項目5_10()).add(加算対象));
    }

    private void create介護給付費5_7(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目5_7(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目5_7(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目5_7(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目5_7(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目5_7(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目5_8(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_4);
        if (集計項目Entity.get集計項目5_8() == null) {

            集計項目Entity.set集計項目5_8(加算対象);
        } else {
            集計項目Entity.set集計項目5_8(集計項目Entity.get集計項目5_8().add(加算対象));
        }
        集計項目Entity.set集計項目5_10(nullToZero(集計項目Entity.get集計項目5_10()).add(加算対象));
    }

    private void create介護給付費5_8(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目5_8(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目5_8(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目5_8(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目5_8(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目5_8(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目5_9(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_4);
        if (集計項目Entity.get集計項目5_9() == null) {

            集計項目Entity.set集計項目5_9(加算対象);
        } else {
            集計項目Entity.set集計項目5_9(集計項目Entity.get集計項目5_9().add(加算対象));
        }
        集計項目Entity.set集計項目5_10(nullToZero(集計項目Entity.get集計項目5_10()).add(加算対象));
    }

    private void create介護給付費5_9(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目5_9(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目5_9(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目5_9(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目5_9(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目5_9(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    /**
     * 特定入所費を作成します
     *
     * @param entity 処理対象データEntity
     * @param 統計用サービス種類 統計用サービス種類
     */
    public void get特定入所費(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (!利用状況統計表集計結果Map.containsKey(統計用サービス種類)) {
            return;
        }
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (リスト_サービス種類集計 == null) {
            リスト_サービス種類集計 = new ArrayList<>();
            RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計entity;
            for (int i = 0; i < 数字_7; i++) {
                集計entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
                集計entity.setサービス種類コード(tokeihyo_EditPattern.getコード());
                リスト_サービス種類集計.add(集計entity);
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(リスト_サービス種類集計);
        }
        if (!tokeihyo_EditPattern.is介護給付費集計有無()) {
            return;
        }
        Decimal 集計対象 = new Decimal(entity.getTokuteiNyushoShokuhiSeikyugaku().toString())
                .add(new Decimal(entity.getTokuteiNyushoKyojuSeikyugaku().toString()));
        if (YoKaigoJotaiKubun.非該当.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create特定入所費6_1(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要支援1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create特定入所費6_2(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要支援2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create特定入所費6_3(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要支援_経過的要介護.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create特定入所費6_4(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create特定入所費6_5(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create特定入所費6_6(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護3.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create特定入所費6_7(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護4.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create特定入所費6_8(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護5.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create特定入所費6_9(統計用サービス種類, 集計対象);
        }
    }

    private void create集計項目6_1(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_5);
        if (集計項目Entity.get集計項目6_1() == null) {

            集計項目Entity.set集計項目6_1(加算対象);
        } else {
            集計項目Entity.set集計項目6_1(集計項目Entity.get集計項目6_1().add(加算対象));
        }
        集計項目Entity.set集計項目6_10(nullToZero(集計項目Entity.get集計項目6_10()).add(加算対象));
    }

    private void create特定入所費6_1(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目6_1(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目6_1(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目6_1(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目6_1(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目6_1(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目6_2(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_5);
        if (集計項目Entity.get集計項目6_2() == null) {

            集計項目Entity.set集計項目6_2(加算対象);
        } else {
            集計項目Entity.set集計項目6_2(集計項目Entity.get集計項目6_2().add(加算対象));
        }
        集計項目Entity.set集計項目6_10(nullToZero(集計項目Entity.get集計項目6_10()).add(加算対象));
    }

    private void create特定入所費6_2(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目6_2(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目6_2(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目6_2(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目6_2(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目6_2(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目6_3(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_5);
        if (集計項目Entity.get集計項目6_3() == null) {

            集計項目Entity.set集計項目6_3(加算対象);
        } else {
            集計項目Entity.set集計項目6_3(集計項目Entity.get集計項目6_3().add(加算対象));
        }
        集計項目Entity.set集計項目6_10(nullToZero(集計項目Entity.get集計項目6_10()).add(加算対象));
    }

    private void create特定入所費6_3(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目6_3(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目6_3(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目6_3(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目6_3(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目6_3(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目6_4(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_5);
        if (集計項目Entity.get集計項目6_4() == null) {

            集計項目Entity.set集計項目6_4(加算対象);
        } else {
            集計項目Entity.set集計項目6_4(集計項目Entity.get集計項目6_4().add(加算対象));
        }
        集計項目Entity.set集計項目6_10(nullToZero(集計項目Entity.get集計項目6_10()).add(加算対象));
    }

    private void create特定入所費6_4(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目6_4(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目6_4(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目6_4(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目6_4(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目6_4(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目6_5(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_5);
        if (集計項目Entity.get集計項目6_5() == null) {

            集計項目Entity.set集計項目6_5(加算対象);
        } else {
            集計項目Entity.set集計項目6_5(集計項目Entity.get集計項目6_5().add(加算対象));
        }
        集計項目Entity.set集計項目6_10(nullToZero(集計項目Entity.get集計項目6_10()).add(加算対象));
    }

    private void create特定入所費6_5(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目6_5(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目6_5(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目6_5(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目6_5(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目6_5(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目6_6(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_5);
        if (集計項目Entity.get集計項目6_6() == null) {

            集計項目Entity.set集計項目6_6(加算対象);
        } else {
            集計項目Entity.set集計項目6_6(集計項目Entity.get集計項目6_6().add(加算対象));
        }
        集計項目Entity.set集計項目6_10(nullToZero(集計項目Entity.get集計項目6_10()).add(加算対象));
    }

    private void create特定入所費6_6(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目6_6(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目6_6(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目6_6(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目6_6(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目6_6(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目6_7(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_5);
        if (集計項目Entity.get集計項目6_7() == null) {

            集計項目Entity.set集計項目6_7(加算対象);
        } else {
            集計項目Entity.set集計項目6_7(集計項目Entity.get集計項目6_7().add(加算対象));
        }
        集計項目Entity.set集計項目6_10(nullToZero(集計項目Entity.get集計項目6_10()).add(加算対象));
    }

    private void create特定入所費6_7(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目6_7(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目6_7(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目6_7(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目6_7(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目6_7(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目6_8(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_5);
        if (集計項目Entity.get集計項目6_8() == null) {

            集計項目Entity.set集計項目6_8(加算対象);
        } else {
            集計項目Entity.set集計項目6_8(集計項目Entity.get集計項目6_8().add(加算対象));
        }
        集計項目Entity.set集計項目6_10(nullToZero(集計項目Entity.get集計項目6_10()).add(加算対象));
    }

    private void create特定入所費6_8(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目6_8(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目6_8(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目6_8(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目6_8(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目6_8(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目6_9(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_5);
        if (集計項目Entity.get集計項目6_9() == null) {

            集計項目Entity.set集計項目6_9(加算対象);
        } else {
            集計項目Entity.set集計項目6_9(集計項目Entity.get集計項目6_9().add(加算対象));
        }
        集計項目Entity.set集計項目6_10(nullToZero(集計項目Entity.get集計項目6_10()).add(加算対象));
    }

    private void create特定入所費6_9(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目6_9(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目6_9(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目6_9(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目6_9(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目6_9(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private Decimal nullToZero(Decimal del) {
        if (del == null) {
            return Decimal.ZERO;
        }
        return del;
    }
}
