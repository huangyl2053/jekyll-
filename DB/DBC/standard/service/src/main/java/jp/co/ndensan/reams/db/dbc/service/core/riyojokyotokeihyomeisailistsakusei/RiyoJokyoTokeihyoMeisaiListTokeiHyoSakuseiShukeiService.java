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
public class RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiShukeiService {

    private static final int 数字_7 = 7;
    private static final int 数字_6 = 6;
    private static final int 数字_5 = 5;
    private static final int 数字_4 = 4;
    private static final int 数字_3 = 3;
    private static final int 数字_2 = 2;
    private static final int 数字_1 = 1;
    private static final int 数字_0 = 0;
    private final Map<RString, RiyoJokyoTokeihyoShukeiKekkaEntity> 利用状況統計表集計結果Map;
    private final boolean 利用実人員登録フラグ;

    /**
     * コンストラクタです。
     *
     * @param 利用状況統計表集計結果Map 利用状況統計表集計結果Map
     * @param 利用実人員登録フラグ 利用実人員登録フラグ
     */
    public RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiShukeiService(Map<RString, RiyoJokyoTokeihyoShukeiKekkaEntity> 利用状況統計表集計結果Map,
            boolean 利用実人員登録フラグ) {
        this.利用状況統計表集計結果Map = 利用状況統計表集計結果Map;
        this.利用実人員登録フラグ = 利用実人員登録フラグ;
    }

    /**
     * createInstanceのメソドです。
     *
     * @return 利用状況統計表（明細リスト）作成サービスクラス
     */
    public static RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiShukeiService createInstance() {
        return InstanceProvider.create(RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiShukeiService.class);
    }

    /**
     * 社福軽減額を作成します
     *
     * @param entity 処理対象データEntity
     * @param 統計用サービス種類 統計用サービス種類
     */
    public void get社福軽減額(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
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
        if (!tokeihyo_EditPattern.is社福軽減額集計有無()) {
            return;
        }
        Decimal 集計対象 = new Decimal(entity.getShafukuKeigengaku().toString());
        if (YoKaigoJotaiKubun.非該当.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create社福軽減額7_1(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要支援1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create社福軽減額7_2(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要支援2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create社福軽減額7_3(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要支援_経過的要介護.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create社福軽減額7_4(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create社福軽減額7_5(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create社福軽減額7_6(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護3.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create社福軽減額7_7(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護4.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create社福軽減額7_8(統計用サービス種類, 集計対象);
        } else if (YoKaigoJotaiKubun.要介護5.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create社福軽減額7_9(統計用サービス種類, 集計対象);
        }
    }

    private void create集計項目7_1(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_6);
        if (集計項目Entity.get集計項目7_1() == null) {

            集計項目Entity.set集計項目7_1(加算対象);
        } else {
            集計項目Entity.set集計項目7_1(集計項目Entity.get集計項目7_1().add(加算対象));
        }
        集計項目Entity.set集計項目7_10(nullToZero(集計項目Entity.get集計項目7_10()).add(加算対象));
    }

    private void create社福軽減額7_1(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目7_1(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目7_1(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目7_1(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目7_1(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目7_1(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目7_2(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_6);
        if (集計項目Entity.get集計項目7_2() == null) {

            集計項目Entity.set集計項目7_2(加算対象);
        } else {
            集計項目Entity.set集計項目7_2(集計項目Entity.get集計項目7_2().add(加算対象));
        }
        集計項目Entity.set集計項目7_10(nullToZero(集計項目Entity.get集計項目7_10()).add(加算対象));
    }

    private void create社福軽減額7_2(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目7_2(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目7_2(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目7_2(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目7_2(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目7_2(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目7_3(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_6);
        if (集計項目Entity.get集計項目7_3() == null) {

            集計項目Entity.set集計項目7_3(加算対象);
        } else {
            集計項目Entity.set集計項目7_3(集計項目Entity.get集計項目7_3().add(加算対象));
        }
        集計項目Entity.set集計項目7_10(nullToZero(集計項目Entity.get集計項目7_10()).add(加算対象));
    }

    private void create社福軽減額7_3(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目7_3(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目7_3(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目7_3(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目7_3(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目7_3(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目7_4(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_6);
        if (集計項目Entity.get集計項目7_4() == null) {

            集計項目Entity.set集計項目7_4(加算対象);
        } else {
            集計項目Entity.set集計項目7_4(集計項目Entity.get集計項目7_4().add(加算対象));
        }
        集計項目Entity.set集計項目7_10(nullToZero(集計項目Entity.get集計項目7_10()).add(加算対象));
    }

    private void create社福軽減額7_4(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目7_4(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目7_4(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目7_4(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目7_4(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目7_4(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目7_5(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_6);
        if (集計項目Entity.get集計項目7_5() == null) {

            集計項目Entity.set集計項目7_5(加算対象);
        } else {
            集計項目Entity.set集計項目7_5(集計項目Entity.get集計項目7_5().add(加算対象));
        }
        集計項目Entity.set集計項目7_10(nullToZero(集計項目Entity.get集計項目7_10()).add(加算対象));
    }

    private void create社福軽減額7_5(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目7_5(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目7_5(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目7_5(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目7_5(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目7_5(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目7_6(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_6);
        if (集計項目Entity.get集計項目7_6() == null) {

            集計項目Entity.set集計項目7_6(加算対象);
        } else {
            集計項目Entity.set集計項目7_6(集計項目Entity.get集計項目7_6().add(加算対象));
        }
        集計項目Entity.set集計項目7_10(nullToZero(集計項目Entity.get集計項目7_10()).add(加算対象));
    }

    private void create社福軽減額7_6(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目7_6(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目7_6(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目7_6(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目7_6(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目7_6(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目7_7(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_6);
        if (集計項目Entity.get集計項目7_7() == null) {

            集計項目Entity.set集計項目7_7(加算対象);
        } else {
            集計項目Entity.set集計項目7_7(集計項目Entity.get集計項目7_7().add(加算対象));
        }
        集計項目Entity.set集計項目7_10(nullToZero(集計項目Entity.get集計項目7_10()).add(加算対象));
    }

    private void create社福軽減額7_7(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目7_7(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目7_7(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目7_7(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目7_7(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目7_7(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目7_8(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_6);
        if (集計項目Entity.get集計項目7_8() == null) {

            集計項目Entity.set集計項目7_8(加算対象);
        } else {
            集計項目Entity.set集計項目7_8(集計項目Entity.get集計項目7_8().add(加算対象));
        }
        集計項目Entity.set集計項目7_10(nullToZero(集計項目Entity.get集計項目7_10()).add(加算対象));
    }

    private void create社福軽減額7_8(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目7_8(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目7_8(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目7_8(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目7_8(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目7_8(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    private void create集計項目7_9(RString 統計用サービス種類, Decimal 加算対象) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_6);
        if (集計項目Entity.get集計項目7_9() == null) {

            集計項目Entity.set集計項目7_9(加算対象);
        } else {
            集計項目Entity.set集計項目7_9(集計項目Entity.get集計項目7_9().add(加算対象));
        }
        集計項目Entity.set集計項目7_10(nullToZero(集計項目Entity.get集計項目7_10()).add(加算対象));
    }

    private void create社福軽減額7_9(RString 統計用サービス種類, Decimal 加算対象) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);

        create集計項目7_9(統計用サービス種類, 加算対象);
        if (tokeihyo_EditPattern.is居宅サービス計加算有無()) {
            create集計項目7_9(RiyojokyoTokeihyo_EditPattern.居宅サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
            create集計項目7_9(RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
            create集計項目7_9(RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), 加算対象);
        }
        if (tokeihyo_EditPattern.is介護給付費計加算有無()) {
            create集計項目7_9(RiyojokyoTokeihyo_EditPattern.介護給付費計.getコード(), 加算対象);
        }
    }

    /**
     * 特定入所者介護サービスを作成します
     *
     * @param entity 処理対象データEntity
     * @param サービス種類 サービス種類
     */
    public void get特定入所者介護サービス(DbWT1513RiyoJokyoTokeihyoEntity entity, RString サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(サービス種類);
        RString 統計用サービス種類 = RiyojokyoTokeihyo_EditPattern.特定入所者.getコード();
        if (!利用状況統計表集計結果Map.containsKey(統計用サービス種類)) {
            return;
        }
        if (!tokeihyo_EditPattern.is特定入所者計加算有無()) {
            return;
        }
        Decimal 特定入所日数食費 = new Decimal(entity.getTokuteiNyushoShokuhiNissu().toString());
        Decimal 特定入所費用額食費 = new Decimal(entity.getTokuteiNyushoShokuhiHiyogaku().toString());
        Decimal 特定入所保険分請求額食費 = new Decimal(entity.getTokuteiNyushoShokuhiSeikyugaku().toString());
        Decimal 特定入所日数居住 = new Decimal(entity.getTokuteiNyushoKyojuNissu().toString());
        Decimal 特定入所費用額居住 = new Decimal(entity.getTokuteiNyushoKyojuHiyogaku().toString());
        Decimal 特定入所保険分請求額居住 = new Decimal(entity.getTokuteiNyushoKyojuSeikyugaku().toString());
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
        boolean is集計 = add特定入所者介護サービス(entity, 統計用サービス種類);
        リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目2集計 = リスト_サービス種類集計.get(数字_1);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目3集計 = リスト_サービス種類集計.get(数字_2);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目4集計 = リスト_サービス種類集計.get(数字_3);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目5集計 = リスト_サービス種類集計.get(数字_4);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目6集計 = リスト_サービス種類集計.get(数字_5);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目7集計 = リスト_サービス種類集計.get(数字_6);
        if (is集計) {
            集計項目2集計.set集計項目2_10(nullToZero(集計項目2集計.get集計項目2_10()).add(特定入所日数食費));
            集計項目3集計.set集計項目3_10(nullToZero(集計項目3集計.get集計項目3_10()).add(特定入所費用額食費));
            集計項目4集計.set集計項目4_10(nullToZero(集計項目4集計.get集計項目4_10()).add(特定入所保険分請求額食費));
            集計項目5集計.set集計項目5_10(nullToZero(集計項目5集計.get集計項目5_10()).add(特定入所日数居住));
            集計項目6集計.set集計項目6_10(nullToZero(集計項目6集計.get集計項目6_10()).add(特定入所費用額居住));
            集計項目7集計.set集計項目7_10(nullToZero(集計項目7集計.get集計項目7_10()).add(特定入所保険分請求額居住));
        }
    }

    private boolean add特定入所者介護サービス(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();

        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目1集計 = リスト_サービス種類集計.get(数字_0);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目2集計 = リスト_サービス種類集計.get(数字_1);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目3集計 = リスト_サービス種類集計.get(数字_2);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目4集計 = リスト_サービス種類集計.get(数字_3);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目5集計 = リスト_サービス種類集計.get(数字_4);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目6集計 = リスト_サービス種類集計.get(数字_5);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目7集計 = リスト_サービス種類集計.get(数字_6);
        Decimal 特定入所日数食費 = new Decimal(entity.getTokuteiNyushoShokuhiNissu().toString());
        Decimal 特定入所費用額食費 = new Decimal(entity.getTokuteiNyushoShokuhiHiyogaku().toString());
        Decimal 特定入所保険分請求額食費 = new Decimal(entity.getTokuteiNyushoShokuhiSeikyugaku().toString());
        Decimal 特定入所日数居住 = new Decimal(entity.getTokuteiNyushoKyojuNissu().toString());
        Decimal 特定入所費用額居住 = new Decimal(entity.getTokuteiNyushoKyojuHiyogaku().toString());
        Decimal 特定入所保険分請求額居住 = new Decimal(entity.getTokuteiNyushoKyojuSeikyugaku().toString());
        boolean isExists = false;
        if (YoKaigoJotaiKubun.非該当.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目2集計.set集計項目2_1(nullToZero(集計項目2集計.get集計項目2_1()).add(特定入所日数食費));
            集計項目3集計.set集計項目3_1(nullToZero(集計項目3集計.get集計項目3_1()).add(特定入所費用額食費));
            集計項目4集計.set集計項目4_1(nullToZero(集計項目4集計.get集計項目4_1()).add(特定入所保険分請求額食費));
            集計項目5集計.set集計項目5_1(nullToZero(集計項目5集計.get集計項目5_1()).add(特定入所日数居住));
            集計項目6集計.set集計項目6_1(nullToZero(集計項目6集計.get集計項目6_1()).add(特定入所費用額居住));
            集計項目7集計.set集計項目7_1(nullToZero(集計項目7集計.get集計項目7_1()).add(特定入所保険分請求額居住));
            isExists = true;
            if (is集計項目1(entity)) {
                集計項目1集計.set集計項目1_1(nullToZero(集計項目1集計.get集計項目1_1()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要支援1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目2集計.set集計項目2_2(nullToZero(集計項目2集計.get集計項目2_2()).add(特定入所日数食費));
            集計項目3集計.set集計項目3_2(nullToZero(集計項目3集計.get集計項目3_2()).add(特定入所費用額食費));
            集計項目4集計.set集計項目4_2(nullToZero(集計項目4集計.get集計項目4_2()).add(特定入所保険分請求額食費));
            集計項目5集計.set集計項目5_2(nullToZero(集計項目5集計.get集計項目5_2()).add(特定入所日数居住));
            集計項目6集計.set集計項目6_2(nullToZero(集計項目6集計.get集計項目6_2()).add(特定入所費用額居住));
            集計項目7集計.set集計項目7_2(nullToZero(集計項目7集計.get集計項目7_2()).add(特定入所保険分請求額居住));
            isExists = true;
            if (is集計項目1(entity)) {
                集計項目1集計.set集計項目1_2(集計項目1集計.get集計項目1_2().add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(集計項目1集計.get集計項目1_10().add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要支援2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目2集計.set集計項目2_3(nullToZero(集計項目2集計.get集計項目2_3()).add(特定入所日数食費));
            集計項目3集計.set集計項目3_3(nullToZero(集計項目3集計.get集計項目3_3()).add(特定入所費用額食費));
            集計項目4集計.set集計項目4_3(nullToZero(集計項目4集計.get集計項目4_3()).add(特定入所保険分請求額食費));
            集計項目5集計.set集計項目5_3(nullToZero(集計項目5集計.get集計項目5_3()).add(特定入所日数居住));
            集計項目6集計.set集計項目6_3(nullToZero(集計項目6集計.get集計項目6_3()).add(特定入所費用額居住));
            集計項目7集計.set集計項目7_3(nullToZero(集計項目7集計.get集計項目7_3()).add(特定入所保険分請求額居住));
            isExists = true;
            if (is集計項目1(entity)) {
                集計項目1集計.set集計項目1_3(集計項目1集計.get集計項目1_3().add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(集計項目1集計.get集計項目1_10().add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要支援_経過的要介護.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目2集計.set集計項目2_4(nullToZero(集計項目2集計.get集計項目2_4()).add(特定入所日数食費));
            集計項目3集計.set集計項目3_4(nullToZero(集計項目3集計.get集計項目3_4()).add(特定入所費用額食費));
            集計項目4集計.set集計項目4_4(nullToZero(集計項目4集計.get集計項目4_4()).add(特定入所保険分請求額食費));
            集計項目5集計.set集計項目5_4(nullToZero(集計項目5集計.get集計項目5_4()).add(特定入所日数居住));
            集計項目6集計.set集計項目6_4(nullToZero(集計項目6集計.get集計項目6_4()).add(特定入所費用額居住));
            集計項目7集計.set集計項目7_4(nullToZero(集計項目7集計.get集計項目7_4()).add(特定入所保険分請求額居住));
            isExists = true;
            if (is集計項目1(entity)) {
                集計項目1集計.set集計項目1_4(nullToZero(集計項目1集計.get集計項目1_4()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要介護1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目2集計.set集計項目2_5(nullToZero(集計項目2集計.get集計項目2_5()).add(特定入所日数食費));
            集計項目3集計.set集計項目3_5(nullToZero(集計項目3集計.get集計項目3_5()).add(特定入所費用額食費));
            集計項目4集計.set集計項目4_5(nullToZero(集計項目4集計.get集計項目4_5()).add(特定入所保険分請求額食費));
            集計項目5集計.set集計項目5_5(nullToZero(集計項目5集計.get集計項目5_5()).add(特定入所日数居住));
            集計項目6集計.set集計項目6_5(nullToZero(集計項目6集計.get集計項目6_5()).add(特定入所費用額居住));
            集計項目7集計.set集計項目7_5(nullToZero(集計項目7集計.get集計項目7_5()).add(特定入所保険分請求額居住));
            isExists = true;
            if (is集計項目1(entity)) {
                集計項目1集計.set集計項目1_5(nullToZero(集計項目1集計.get集計項目1_5()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要介護2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目2集計.set集計項目2_6(nullToZero(集計項目2集計.get集計項目2_6()).add(特定入所日数食費));
            集計項目3集計.set集計項目3_6(nullToZero(集計項目3集計.get集計項目3_6()).add(特定入所費用額食費));
            集計項目4集計.set集計項目4_6(nullToZero(集計項目4集計.get集計項目4_6()).add(特定入所保険分請求額食費));
            集計項目5集計.set集計項目5_6(nullToZero(集計項目5集計.get集計項目5_6()).add(特定入所日数居住));
            集計項目6集計.set集計項目6_6(nullToZero(集計項目6集計.get集計項目6_6()).add(特定入所費用額居住));
            集計項目7集計.set集計項目7_6(nullToZero(集計項目7集計.get集計項目7_6()).add(特定入所保険分請求額居住));
            if (is集計項目1(entity)) {
                集計項目1集計.set集計項目1_6(nullToZero(集計項目1集計.get集計項目1_6()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要介護3.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目2集計.set集計項目2_7(nullToZero(集計項目2集計.get集計項目2_7()).add(特定入所日数食費));
            集計項目3集計.set集計項目3_7(nullToZero(集計項目3集計.get集計項目3_7()).add(特定入所費用額食費));
            集計項目4集計.set集計項目4_7(nullToZero(集計項目4集計.get集計項目4_7()).add(特定入所保険分請求額食費));
            集計項目5集計.set集計項目5_7(nullToZero(集計項目5集計.get集計項目5_7()).add(特定入所日数居住));
            集計項目6集計.set集計項目6_7(nullToZero(集計項目6集計.get集計項目6_7()).add(特定入所費用額居住));
            集計項目7集計.set集計項目7_7(nullToZero(集計項目7集計.get集計項目7_7()).add(特定入所保険分請求額居住));
            isExists = true;
            if (is集計項目1(entity)) {
                集計項目1集計.set集計項目1_7(nullToZero(集計項目1集計.get集計項目1_7()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要介護4.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目2集計.set集計項目2_8(nullToZero(集計項目2集計.get集計項目2_8()).add(特定入所日数食費));
            集計項目3集計.set集計項目3_8(nullToZero(集計項目3集計.get集計項目3_8()).add(特定入所費用額食費));
            集計項目4集計.set集計項目4_8(nullToZero(集計項目4集計.get集計項目4_8()).add(特定入所保険分請求額食費));
            集計項目5集計.set集計項目5_8(nullToZero(集計項目5集計.get集計項目5_8()).add(特定入所日数居住));
            集計項目6集計.set集計項目6_8(nullToZero(集計項目6集計.get集計項目6_8()).add(特定入所費用額居住));
            集計項目7集計.set集計項目7_8(nullToZero(集計項目7集計.get集計項目7_8()).add(特定入所保険分請求額居住));
            isExists = true;
            if (is集計項目1(entity)) {
                集計項目1集計.set集計項目1_8(nullToZero(集計項目1集計.get集計項目1_8()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要介護5.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目2集計.set集計項目2_9(nullToZero(集計項目2集計.get集計項目2_9()).add(特定入所日数食費));
            集計項目3集計.set集計項目3_9(nullToZero(集計項目3集計.get集計項目3_9()).add(特定入所費用額食費));
            集計項目4集計.set集計項目4_9(nullToZero(集計項目4集計.get集計項目4_9()).add(特定入所保険分請求額食費));
            集計項目5集計.set集計項目5_9(nullToZero(集計項目5集計.get集計項目5_9()).add(特定入所日数居住));
            集計項目6集計.set集計項目6_9(nullToZero(集計項目6集計.get集計項目6_9()).add(特定入所費用額居住));
            集計項目7集計.set集計項目7_9(nullToZero(集計項目7集計.get集計項目7_9()).add(特定入所保険分請求額居住));
            isExists = true;
            if (is集計項目1(entity)) {
                集計項目1集計.set集計項目1_9(nullToZero(集計項目1集計.get集計項目1_9()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        }
        return isExists;
    }

    private boolean is集計項目1(DbWT1513RiyoJokyoTokeihyoEntity entity) {
        Decimal 特定入所日数食費 = new Decimal(entity.getTokuteiNyushoShokuhiNissu().toString());
        Decimal 特定入所費用額食費 = new Decimal(entity.getTokuteiNyushoShokuhiHiyogaku().toString());
        Decimal 特定入所保険分請求額食費 = new Decimal(entity.getTokuteiNyushoShokuhiSeikyugaku().toString());
        Decimal 特定入所日数居住 = new Decimal(entity.getTokuteiNyushoKyojuNissu().toString());
        Decimal 特定入所費用額居住 = new Decimal(entity.getTokuteiNyushoKyojuHiyogaku().toString());
        Decimal 特定入所保険分請求額居住 = new Decimal(entity.getTokuteiNyushoKyojuSeikyugaku().toString());
        return 利用実人員登録フラグ && (0 < 特定入所日数食費.intValue() && 0 < 特定入所費用額食費.intValue()
                && 0 < 特定入所保険分請求額食費.intValue() && 0 < 特定入所日数居住.intValue()
                && 0 < 特定入所費用額居住.intValue() && 0 < 特定入所保険分請求額居住.intValue());
    }

    /**
     * 社会福祉法人軽減額を取得します。
     *
     * @param entity 処理対象データEntity
     * @param サービス種類 サービス種類
     */
    public void get社会福祉法人軽減額(DbWT1513RiyoJokyoTokeihyoEntity entity, RString サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(サービス種類);
        RString 統計用サービス種類 = RiyojokyoTokeihyo_EditPattern.社福.getコード();
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
        if (!tokeihyo_EditPattern.is社福計加算有無()) {
            return;
        }
        Decimal 社福受領すべき利用者負担額 = new Decimal(entity.getShafukuRiyoshaFutangaku().toString());
        Decimal 社福軽減額 = new Decimal(entity.getShafukuKeigengaku().toString());
        Decimal 社福軽減後利用者負担額 = new Decimal(entity.getShafukuKeigengoRiyoshaFutangaku().toString());
        boolean is集計 = add社会福祉法人軽減額(entity, 統計用サービス種類);
        リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目4集計 = リスト_サービス種類集計.get(数字_3);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目5集計 = リスト_サービス種類集計.get(数字_4);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目6集計 = リスト_サービス種類集計.get(数字_5);
        if (is集計) {
            集計項目4集計.set集計項目4_10(nullToZero(集計項目4集計.get集計項目4_10()).add(社福受領すべき利用者負担額));
            集計項目5集計.set集計項目5_10(nullToZero(集計項目5集計.get集計項目5_10()).add(社福軽減額));
            集計項目6集計.set集計項目6_10(nullToZero(集計項目6集計.get集計項目6_10()).add(社福軽減後利用者負担額));
        }
    }

    private boolean add社会福祉法人軽減額(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {

        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        boolean isExists = false;
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目1集計 = リスト_サービス種類集計.get(数字_0);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目4集計 = リスト_サービス種類集計.get(数字_3);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目5集計 = リスト_サービス種類集計.get(数字_4);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目6集計 = リスト_サービス種類集計.get(数字_5);
        Decimal 社福受領すべき利用者負担額 = new Decimal(entity.getShafukuRiyoshaFutangaku().toString());
        Decimal 社福軽減額 = new Decimal(entity.getShafukuKeigengaku().toString());
        Decimal 社福軽減後利用者負担額 = new Decimal(entity.getShafukuKeigengoRiyoshaFutangaku().toString());
        if (YoKaigoJotaiKubun.非該当.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目4集計.set集計項目4_1(nullToZero(集計項目4集計.get集計項目4_1()).add(社福受領すべき利用者負担額));
            集計項目5集計.set集計項目5_1(nullToZero(集計項目5集計.get集計項目5_1()).add(社福軽減額));
            集計項目6集計.set集計項目6_1(nullToZero(集計項目6集計.get集計項目6_1()).add(社福軽減後利用者負担額));
            isExists = true;
            if (is社福計加算集計項目１(entity)) {
                集計項目1集計.set集計項目1_1(nullToZero(集計項目1集計.get集計項目1_1()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要支援1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目4集計.set集計項目4_2(nullToZero(集計項目4集計.get集計項目4_2()).add(社福受領すべき利用者負担額));
            集計項目5集計.set集計項目5_2(nullToZero(集計項目5集計.get集計項目5_2()).add(社福軽減額));
            集計項目6集計.set集計項目6_2(nullToZero(集計項目6集計.get集計項目6_2()).add(社福軽減後利用者負担額));
            isExists = true;
            if (is社福計加算集計項目１(entity)) {
                集計項目1集計.set集計項目1_2(nullToZero(集計項目1集計.get集計項目1_2()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要支援2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目4集計.set集計項目4_3(nullToZero(集計項目4集計.get集計項目4_3()).add(社福受領すべき利用者負担額));
            集計項目5集計.set集計項目5_3(nullToZero(集計項目5集計.get集計項目5_3()).add(社福軽減額));
            集計項目6集計.set集計項目6_3(nullToZero(集計項目6集計.get集計項目6_3()).add(社福軽減後利用者負担額));
            isExists = true;
            if (is社福計加算集計項目１(entity)) {
                集計項目1集計.set集計項目1_3(nullToZero(集計項目1集計.get集計項目1_3()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要支援_経過的要介護.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目4集計.set集計項目4_4(nullToZero(集計項目4集計.get集計項目4_4()).add(社福受領すべき利用者負担額));
            集計項目5集計.set集計項目5_4(nullToZero(集計項目5集計.get集計項目5_4()).add(社福軽減額));
            集計項目6集計.set集計項目6_4(nullToZero(集計項目6集計.get集計項目6_4()).add(社福軽減後利用者負担額));
            isExists = true;
            if (is社福計加算集計項目１(entity)) {
                集計項目1集計.set集計項目1_4(集計項目1集計.get集計項目1_4().add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(集計項目1集計.get集計項目1_10().add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要介護1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目4集計.set集計項目4_5(nullToZero(集計項目4集計.get集計項目4_5()).add(社福受領すべき利用者負担額));
            集計項目5集計.set集計項目5_5(nullToZero(集計項目5集計.get集計項目5_5()).add(社福軽減額));
            集計項目6集計.set集計項目6_5(nullToZero(集計項目6集計.get集計項目6_5()).add(社福軽減後利用者負担額));
            isExists = true;
            if (is社福計加算集計項目１(entity)) {
                集計項目1集計.set集計項目1_5(nullToZero(集計項目1集計.get集計項目1_5()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要介護2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目4集計.set集計項目4_6(nullToZero(集計項目4集計.get集計項目4_6()).add(社福受領すべき利用者負担額));
            集計項目5集計.set集計項目5_6(nullToZero(集計項目5集計.get集計項目5_6()).add(社福軽減額));
            集計項目6集計.set集計項目6_6(nullToZero(集計項目6集計.get集計項目6_6()).add(社福軽減後利用者負担額));
            if (is集計項目1(entity)) {
                集計項目1集計.set集計項目1_6(nullToZero(集計項目1集計.get集計項目1_6()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要介護3.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目4集計.set集計項目4_7(nullToZero(集計項目4集計.get集計項目4_7()).add(社福受領すべき利用者負担額));
            集計項目5集計.set集計項目5_7(nullToZero(集計項目5集計.get集計項目5_7()).add(社福軽減額));
            集計項目6集計.set集計項目6_7(nullToZero(集計項目6集計.get集計項目6_7()).add(社福軽減後利用者負担額));
            isExists = true;
            if (is社福計加算集計項目１(entity)) {
                集計項目1集計.set集計項目1_7(nullToZero(集計項目1集計.get集計項目1_7()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要介護4.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目4集計.set集計項目4_8(nullToZero(集計項目4集計.get集計項目4_8()).add(社福受領すべき利用者負担額));
            集計項目5集計.set集計項目5_8(nullToZero(集計項目5集計.get集計項目5_8()).add(社福軽減額));
            集計項目6集計.set集計項目6_8(nullToZero(集計項目6集計.get集計項目6_8()).add(社福軽減後利用者負担額));
            isExists = true;
            if (is社福計加算集計項目１(entity)) {
                集計項目1集計.set集計項目1_8(nullToZero(集計項目1集計.get集計項目1_8()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        } else if (YoKaigoJotaiKubun.要介護5.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            集計項目4集計.set集計項目4_9(nullToZero(集計項目4集計.get集計項目4_9()).add(社福受領すべき利用者負担額));
            集計項目5集計.set集計項目5_9(nullToZero(集計項目5集計.get集計項目5_9()).add(社福軽減額));
            集計項目6集計.set集計項目6_9(nullToZero(集計項目6集計.get集計項目6_9()).add(社福軽減後利用者負担額));
            isExists = true;
            if (is社福計加算集計項目１(entity)) {
                集計項目1集計.set集計項目1_9(nullToZero(集計項目1集計.get集計項目1_9()).add(Decimal.ONE));
                集計項目1集計.set集計項目1_10(nullToZero(集計項目1集計.get集計項目1_10()).add(Decimal.ONE));
            }
        }
        return isExists;
    }

    private boolean is社福計加算集計項目１(DbWT1513RiyoJokyoTokeihyoEntity entity) {
        Decimal 社福受領すべき利用者負担額 = new Decimal(entity.getShafukuRiyoshaFutangaku().toString());
        Decimal 社福軽減額 = new Decimal(entity.getShafukuKeigengaku().toString());
        Decimal 社福軽減後利用者負担額 = new Decimal(entity.getShafukuKeigengoRiyoshaFutangaku().toString());
        return 利用実人員登録フラグ && (0 < 社福受領すべき利用者負担額.intValue() && 0 < 社福軽減額.intValue()
                && 0 < 社福軽減後利用者負担額.intValue());
    }

    private Decimal nullToZero(Decimal del) {
        if (del == null) {
            return Decimal.ZERO;
        }
        return del;
    }
}
