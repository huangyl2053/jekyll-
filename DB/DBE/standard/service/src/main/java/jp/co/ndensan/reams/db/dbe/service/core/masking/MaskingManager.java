/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.masking;

import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.masking.MaskingParameter;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT5305IkenshoImageJohoMapper;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 完了処理・マスキングのManagerクラスです。
 *
 * @reamsid_L DBE-2080-010 lishengli
 */
public class MaskingManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    MaskingManager() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    public MaskingManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link MaskingManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link MaskingManager}のインスタンス
     */
    public static MaskingManager createInstance() {
        return InstanceProvider.create(MaskingManager.class);
    }

    /**
     * 更新の処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return boolean
     */
    public boolean is更新(RString 申請書管理番号) {
        IDbT5305IkenshoImageJohoMapper mapper = mapperProvider.create(IDbT5305IkenshoImageJohoMapper.class);
        MaskingParameter parameter = new MaskingParameter(申請書管理番号);
        parameter.setMaskDataKubun(GenponMaskKubun.原本.getコード());
        int 原本 = mapper.getイメージ情報数(parameter);
        parameter.setMaskDataKubun(GenponMaskKubun.マスク.getコード());
        int マスク = mapper.getイメージ情報数(parameter);
        return 原本 == マスク;
    }

}
