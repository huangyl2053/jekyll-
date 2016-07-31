/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kanri;

import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住所編集Serviceクラスです。
 *
 * @reamsid_L DBB-9030-010 liangbc
 */
public class JushoHenshuService {

    private final DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac;

    /**
     * コンストラクタです。
     */
    public JushoHenshuService() {
        this.dbT7065Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dbT7065Dac DbT7065ChohyoSeigyoKyotsuDac
     */
    JushoHenshuService(DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac) {
        this.dbT7065Dac = dbT7065Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JushoHenshu}のインスタンスを返します。
     *
     * @return JushoHenshu
     */
    public static JushoHenshuService createInstance() {
        return InstanceProvider.create(JushoHenshuService.class);
    }

    /**
     * 帳票分類IDによって、帳票制御共通情報を取得します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @throws ApplicationException データ存在しない
     * @return 帳票制御共通情報
     */
    public ChohyoSeigyoKyotsu getChohyoSeigyoKyotsuJoho(ReportId 帳票分類ID) {
        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = dbT7065Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID);
        if (dbT7065Entity == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("帳票分類ID"));
        }
        dbT7065Entity.initializeMd5();
        return new ChohyoSeigyoKyotsu(dbT7065Entity);
    }

}
