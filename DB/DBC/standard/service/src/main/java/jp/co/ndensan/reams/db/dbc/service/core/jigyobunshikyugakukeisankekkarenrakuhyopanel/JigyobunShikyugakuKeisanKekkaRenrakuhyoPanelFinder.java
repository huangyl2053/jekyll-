/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jigyobunshikyugakukeisankekkarenrakuhyopanel;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanResultEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuPanelListParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanPanelEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jigyobunshikyugakukeisankekkarenrakuhyo.IJigyobunShikyugakuKeisanPanelMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 事業高額合算支給額計算結果情報取得
 *
 * @reamsid_L DBC-4840-010 lihang
 */
public class JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelFinder {

    private final DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaDac 事業高額合算支給額計算Dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.事業高額合算支給額計算Dac = InstanceProvider.create(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelFinder}のインスタンスを返します。
     *
     * @return HihokenshaDaichoIchiranHyoFinder
     */
    public static JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelFinder createInstance() {
        return InstanceProvider.create(JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelFinder.class);
    }

    /**
     * 被保険者番号存在チェックをします
     *
     * @param 被保険者番号 HihokenshaNo
     * @return チェックフラグ
     */
    public boolean hihokenshaNoCheck(HihokenshaNo 被保険者番号) {
        List<DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity> entityList
                = 事業高額合算支給額計算Dac.select被保険者番号(被保険者番号);
        return entityList == null || entityList.isEmpty();
    }

    /**
     * 事業高額合算支給額計算結果情報を取得します
     *
     * @param parameter
     * JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter
     *
     * @return List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity>
     */
    public List<JigyobunShikyugakuKeisanResultEntity> getJigyobunShikyugakuKeisanKekkaRenrakuhyoPanelList(
            JigyobunShikyugakuPanelListParameter parameter) {

        IJigyobunShikyugakuKeisanPanelMapper mapper = mapperProvider.create(
                IJigyobunShikyugakuKeisanPanelMapper.class);
        List<JigyobunShikyugakuKeisanPanelEntity> list = mapper.get対象データ(parameter);
        List<JigyobunShikyugakuKeisanResultEntity> resultList = new ArrayList<>();
        if (list != null) {
            for (JigyobunShikyugakuKeisanPanelEntity entity : list) {
                JigyobunShikyugakuKeisanResultEntity resultEntity = new JigyobunShikyugakuKeisanResultEntity();
                resultEntity.setTaishoNendo(entity.getTaishoNendo());
                resultEntity.setSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD(entity.getSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD());
                resultEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
                resultEntity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
                resultEntity.setRirekiNo(entity.getRirekiNo());
                resultEntity.setHokenSeidoCode(entity.getHokenSeidoCode());
                resultEntity.setHihokenshaNo(entity.getHihokenshaNo());
                resultEntity.setDbt3173Entity(entity.getDbt3173Entity());
                resultEntity.setDbt3172Entity(entity.getDbt3172Entity());
                resultList.add(resultEntity);
            }
        }
        return resultList;
    }

    /**
     * 事業高額合算支給額計算結果情報を取得します
     *
     * @param parameter
     * JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter
     *
     * @return List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult>
     */
    public List<JigyobunShikyugakuKeisanResultEntity> getJigyobunShikyugakuKeisanKekkaRenrakuhyoPanel(
            JigyobunShikyugakuPanelListParameter parameter) {

        IJigyobunShikyugakuKeisanPanelMapper mapper = mapperProvider.create(
                IJigyobunShikyugakuKeisanPanelMapper.class);
        List<JigyobunShikyugakuKeisanPanelEntity> list = mapper.get処理対象データ(parameter);
        List<JigyobunShikyugakuKeisanResultEntity> resultList = new ArrayList<>();
        if (list != null) {
            for (JigyobunShikyugakuKeisanPanelEntity entity : list) {
                JigyobunShikyugakuKeisanResultEntity resultEntity = new JigyobunShikyugakuKeisanResultEntity();
                resultEntity.setTaishoNendo(entity.getTaishoNendo());
                resultEntity.setSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD(entity.getSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD());
                resultEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
                resultEntity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
                resultEntity.setRirekiNo(entity.getRirekiNo());
                resultEntity.setHokenSeidoCode(entity.getHokenSeidoCode());
                resultEntity.setHihokenshaNo(entity.getHihokenshaNo());
                resultEntity.setDbt3173Entity(entity.getDbt3173Entity());
                resultEntity.setDbt3172Entity(entity.getDbt3172Entity());
                resultList.add(resultEntity);
            }
        }
        return resultList;
    }

    /**
     * entityを保存します。
     *
     * @param entity DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity
     * @return int
     */
    public int saveEntity(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        entity.setState(EntityDataState.Modified);
        return 事業高額合算支給額計算Dac.save(entity);
    }
}
