/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.iryohikojokakuninsinsei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.iryohikojokakuninsinsei.AtesakiParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.iryohikojokakuninsinsei.ShikibetsuTaishoParameter;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.iryohikojokakuninsinsei.IIryoHiKojoKakuninSinseiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計医療費控除確認申請
 *
 * @reamsid_L DBD-5770-030 x_zhaowen
 */
public class IryoHiKojoKakuninSinsei {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public IryoHiKojoKakuninSinsei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * Intanceを作成します。
     *
     * @return IryoHiKojoKakuninSinsei
     */
    public static IryoHiKojoKakuninSinsei createIntance() {
        return InstanceProvider.create(IryoHiKojoKakuninSinsei.class);
    }

    /**
     * 受給者判定
     *
     * @param 被保険者番号 RString
     * @return boolean
     */
    public boolean checkuJukyusha(RString 被保険者番号) {
        IIryoHiKojoKakuninSinseiMapper mapper = mapperProvider.create(IIryoHiKojoKakuninSinseiMapper.class);
        Integer レコード数 = mapper.受給者台帳抽出(被保険者番号);
        return レコード数 > 0;
    }

    /**
     * 受給者台帳取得
     */
    public void getJukyusha() {

    }

    /**
     * 医療費控除取得
     */
    public void getIryohikojyo() {

    }

    /**
     * 単票用医療費控除取得
     */
    public void getIryohikojyo_Chohyo() {

    }

    /**
     * おむつ使用証明書
     */
    public void editomutsusiyoSyomeisho() {

    }

    /**
     * 主治医意見書確認書
     */
    public void editsyujiikensho_Kakunisho() {

    }

    /**
     * 宛名取得
     *
     * @param 識別コード
     * @return IKojin
     */
    public IKojin getAtena_Iryohikojyo(ShikibetsuCode 識別コード) {
        IIryoHiKojoKakuninSinseiMapper mapper = mapperProvider.create(IIryoHiKojoKakuninSinseiMapper.class);

        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_日本人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_外国人);
        key.set住民種別(juminShubetsuList);
        List<JuminJotai> juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住登外);
        juminJotaiList.add(JuminJotai.消除者);
        juminJotaiList.add(JuminJotai.転出者);
        juminJotaiList.add(JuminJotai.死亡者);
        key.set住民状態(juminJotaiList);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        ShikibetsuTaishoParameter param = new ShikibetsuTaishoParameter(shikibetsuTaishoPSMSearchKey);
        param.set識別コード(識別コード);

        UaFt200FindShikibetsuTaishoEntity 宛名情報 = mapper.select宛名情報(param);

        return ShikibetsuTaishoFactory.createKojin(宛名情報);
    }

    /**
     * 宛先取得
     *
     * @param 識別コード
     * @return IAtesaki
     */
    public IAtesaki getAtesaki_Iryohikojyo(ShikibetsuCode 識別コード) {
        IIryoHiKojoKakuninSinseiMapper mapper = mapperProvider.create(IIryoHiKojoKakuninSinseiMapper.class);

        AtesakiPSMSearchKeyBuilder key = new AtesakiPSMSearchKeyBuilder(
                AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        AtesakiParameter param = new AtesakiParameter(key.build());
        param.set識別コード(識別コード);

        UaFt250FindAtesakiEntity 宛先情報 = mapper.select宛先情報(param);
        return AtesakiFactory.createInstance(宛先情報);
    }
}
