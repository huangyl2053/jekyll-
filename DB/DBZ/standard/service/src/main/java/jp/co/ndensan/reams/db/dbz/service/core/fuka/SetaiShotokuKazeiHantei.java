/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.fuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.fuka.SetaiShotokuKazeiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2502KaigoShotokuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiHakuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.fuka.ISetaiShotokuKazeiHanteiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
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
 * @reamsid_L DBB-0640-020 chenaoqi
 */
public class SetaiShotokuKazeiHantei {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SetaiShotokuKazeiHantei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);

    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider MapperProvider
     *
     */
    public SetaiShotokuKazeiHantei(MapperProvider mapperProvider) {
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
        SetaiShotokuKazeiHanteiMybatisParameter parameter = new SetaiShotokuKazeiHanteiMybatisParameter(管理識別区分);
        mapper.insert世帯員所得情報一時が1();
        mapper.insert世帯員所得情報一時が1以外(parameter);

        List<SetaiHakuEntity> 世帯員把握入力List = mapper.get世帯員把握入力Temp();
        if (世帯員把握入力List == null || 世帯員把握入力List.isEmpty()) {
            return;
        }
        for (SetaiHakuEntity 世帯員把握入力Entity : 世帯員把握入力List) {
            ISetaiFinder finder = ShikibetsuTaishoService.getSetaiFinder();
            ISetai isetai = finder.findBy識別コード(GyomuCode.DB介護保険,
                    世帯員把握入力Entity.getShikibetsuCode(),
                    世帯員把握入力Entity.getKijunYMD());
            if (isetai == null) {
                continue;
            }
            IKojins 世帯員リスト = isetai.get世帯員リスト();
            if (世帯員リスト == null) {
                continue;
            }
            for (IKojin iKojin : 世帯員リスト) {
                SetaiShotokuEntity 世帯員所得情報Entity = new SetaiShotokuEntity();
                世帯員所得情報Entity.setHihokenshaNo(世帯員把握入力Entity.getHihokenshaNo());
                世帯員所得情報Entity.setShikibetsuCode(iKojin.get識別コード());
                世帯員所得情報Entity.setKijunYMD(世帯員把握入力Entity.getKijunYMD());
                世帯員所得情報Entity.setShotokuNendo(世帯員把握入力Entity.getShotokuNendo());
                世帯員所得情報Entity.setJushochiTokureiFlag(世帯員把握入力Entity.getJushochiTokureiFlag());
                世帯員所得情報Entity.setSetaiCode(iKojin.get世帯コード());
                if (世帯員把握入力Entity.getShikibetsuCode() != null) {
                    RString 本人区分 = 世帯員把握入力Entity.getShikibetsuCode().equals(iKojin.get識別コード())
                            ? HonninKubun.本人.getCode() : HonninKubun.世帯構成員.getCode();
                    世帯員所得情報Entity.setHonninKubun(本人区分);
                } else {
                    世帯員所得情報Entity.setHonninKubun(HonninKubun.世帯構成員.getCode());
                }
                mapper.insert世帯員所得情報一時(世帯員所得情報Entity);
            }
        }
    }

    /**
     * 各住民の所得情報の取得
     */
    @Transaction
    public void getJuminShotokuJoho() {
        ISetaiShotokuKazeiHanteiMapper mapper = mapperProvider.create(ISetaiShotokuKazeiHanteiMapper.class);
        List<DbV2502KaigoShotokuEntity> 介護所得list = mapper.select介護所得();
        if (介護所得list != null && !介護所得list.isEmpty()) {
            for (DbV2502KaigoShotokuEntity 介護所得entity : 介護所得list) {
                mapper.update世帯員所得情報(介護所得entity);
            }
        }
    }

}
