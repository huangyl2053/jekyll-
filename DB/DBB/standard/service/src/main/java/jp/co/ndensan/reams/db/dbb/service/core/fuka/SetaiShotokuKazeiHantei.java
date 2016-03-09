/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.SetaiShotokuKazeiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2005SetaiHaakuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019SetaiSudeTempEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka.ISetaiShotokuKazeiHanteiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.HonninKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojins;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.setai.ISetai;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.setai.ISetaiFinder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 世帯所得・課税判定（バッチ）
 *
 */
public class SetaiShotokuKazeiHantei {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    SetaiShotokuKazeiHantei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);

    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider MapperProvider
     *
     */
    SetaiShotokuKazeiHantei(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SetaiShotokuKazeiHantei}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SetaiShotokuKazeiHantei}のインスタンス
     */
    public static SetaiShotokuKazeiHantei createInstance() {
        return InstanceProvider.create(SetaiShotokuKazeiHantei.class);
    }

    /**
     * TokuchoKaishiTsuchishoDataHenshu 世帯員（住民）の把握
     *
     * @param 管理識別区分 RString
     */
    @Transaction
    public void getSetaiinHaaku(RString 管理識別区分) {
        ISetaiShotokuKazeiHanteiMapper mapper = mapperProvider.create(ISetaiShotokuKazeiHanteiMapper.class);
        SetaiShotokuKazeiHanteiMybatisParameter parameter = SetaiShotokuKazeiHanteiMybatisParameter.
                createSelectByKeyParam(管理識別区分);
        mapper.insert世帯員所得情報一時が1();
        mapper.insert世帯員所得情報一時が1以外(parameter);

        List<DbT2005SetaiHaakuTempEntity> 世帯員把握入力List = mapper.get世帯員把握入力Temp();

        if (世帯員把握入力List != null && !世帯員把握入力List.isEmpty()) {
            for (DbT2005SetaiHaakuTempEntity 世帯員把握入力Entity : 世帯員把握入力List) {
                ISetaiFinder finder = ShikibetsuTaishoService.getSetaiFinder();
                ISetai isetai = finder.findBy識別コード(GyomuCode.DB介護保険,
                        世帯員把握入力Entity.getShikibetsuCode(),
                        世帯員把握入力Entity.getKijunYMD());
                if (isetai != null) {
                    IKojins 世帯員リスト = isetai.get世帯員リスト();
                    if (世帯員リスト != null) {
                        for (IKojin iKojin : 世帯員リスト) {
                            DbT2019SetaiSudeTempEntity 世帯員所得情報Entity = new DbT2019SetaiSudeTempEntity();
                            世帯員所得情報Entity.setHihokenshaNo(世帯員把握入力Entity.getHihokenshaNo());
                            世帯員所得情報Entity.setShikibetsuCode(iKojin.get識別コード());
                            世帯員所得情報Entity.setKijunYMD(世帯員把握入力Entity.getKijunYMD());
                            世帯員所得情報Entity.setShotokuNendo(世帯員把握入力Entity.getShotokuNendo());
                            世帯員所得情報Entity.setJushochiTokureiFlag(世帯員把握入力Entity.getJushochiTokureiFlag());
                            世帯員所得情報Entity.setSetaiCode(iKojin.get世帯コード());
                            RString 本人区分 = 世帯員把握入力Entity.getShikibetsuCode().equals(iKojin.get識別コード())
                                    ? HonninKubun.本人.getCode() : HonninKubun.世帯構成員.getCode();
                            世帯員所得情報Entity.setHonninKubun(本人区分);
                            mapper.insert世帯員所得情報一時(世帯員所得情報Entity);
                        }
                    }
                }

            }
        }

    }

    /**
     * 各住民の所得情報の取得
     */
    @Transaction
    public void getJuminShotokuJoho() {
        ISetaiShotokuKazeiHanteiMapper mapper = mapperProvider.create(ISetaiShotokuKazeiHanteiMapper.class);
        List<DbT2008ShotokuKanriEntity> 介護所得list = mapper.select介護所得();
        if (介護所得list != null && !介護所得list.isEmpty()) {
            for (DbT2008ShotokuKanriEntity 介護所得entity : 介護所得list) {
                mapper.update世帯員所得情報(介護所得entity);
            }
        }
    }

}
