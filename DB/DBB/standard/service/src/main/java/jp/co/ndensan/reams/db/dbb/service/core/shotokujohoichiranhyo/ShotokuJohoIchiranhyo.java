/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shotokujohoichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohoichiranhyo.TaishoShuryoYmd;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyo.TaishoShuryoYmdEntity;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ51003_所得情報一覧表作成のクラス
 *
 * @reamsid_L DBB-1650-030 lijunjun
 */
public class ShotokuJohoIchiranhyo {

    private static final RString 導入形態コード_112 = new RString("112");
    private static final RString 導入形態コード_120 = new RString("120");
    private static final RString 導入形態コード_111 = new RString("111");
    private final DbT7022ShoriDateKanriDac 処理日付管理マスタDac;

    ShotokuJohoIchiranhyo() {
        処理日付管理マスタDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShotokuJohoIchiranhyo}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShotokuJohoIchiranhyo}のインスタンス
     */
    public static ShotokuJohoIchiranhyo createInstance() {
        return InstanceProvider.create(ShotokuJohoIchiranhyo.class);
    }

    /**
     * 対象終了日時取得する。
     *
     * @param 導入形態コード RString
     * @param 市町村コード LasdecCode
     * @param 広域現市町村リスト List<KoikiZenShichosonJoho>
     * @param 処理年度 FlexibleYear
     * @return List<TaishoShuryoYmd>
     */
    public List<TaishoShuryoYmd> getTaishoShuryoNichiji(RString 導入形態コード,
            LasdecCode 市町村コード,
            List<KoikiZenShichosonJoho> 広域現市町村リスト,
            FlexibleYear 処理年度) {
        if (導入形態コード == null || 処理年度 == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        List<TaishoShuryoYmd> 対象終了日時リスト = new ArrayList<>();
        List<LasdecCode> 市町村コードリスト = new ArrayList<>();
        List<RString> 市町村識別IDリスト = new ArrayList<>();
        if (導入形態コード.equals(導入形態コード_112) || 導入形態コード.equals(導入形態コード_120)) {
            if (市町村コード == null) {
                throw new ApplicationException(UrErrorMessages.検索キーの誤り
                        .getMessage().evaluate());
            }
            List<DbT7022ShoriDateKanriEntity> 処理日付管理マスリスト = 処理日付管理マスタDac
                    .selec対象終了日時(導入形態コード, 市町村コードリスト, 市町村識別IDリスト, 市町村コード, 処理年度);
            for (DbT7022ShoriDateKanriEntity entity : 処理日付管理マスリスト) {
                TaishoShuryoYmdEntity ymdEntity = new TaishoShuryoYmdEntity();
                ymdEntity.set対象終了日時(entity.getTaishoShuryoTimestamp());
                ymdEntity.set市町村コード(entity.getShichosonCode());
                ymdEntity.set年度内連番(entity.getNendoNaiRenban());
                対象終了日時リスト.add(new TaishoShuryoYmd(ymdEntity));
            }
        } else if (導入形態コード.equals(導入形態コード_111)) {
            if (広域現市町村リスト == null || 広域現市町村リスト.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.検索キーの誤り
                        .getMessage().evaluate());
            }
            RString 市町村識別ID;
            for (KoikiZenShichosonJoho chosonJoho : 広域現市町村リスト) {
                市町村識別ID = chosonJoho.get市町村識別ID();
                市町村コード = chosonJoho.get市町村コード();
                市町村コードリスト.add(市町村コード);
                市町村識別IDリスト.add(市町村識別ID);
            }
            List<DbT7022ShoriDateKanriEntity> 処理日付管理マスリスト = 処理日付管理マスタDac
                    .selec対象終了日時(導入形態コード, 市町村コードリスト, 市町村識別IDリスト, 市町村コード, 処理年度);
            for (DbT7022ShoriDateKanriEntity entity : 処理日付管理マスリスト) {
                TaishoShuryoYmdEntity ymdEntity = new TaishoShuryoYmdEntity();
                ymdEntity.set対象終了日時(entity.getTaishoShuryoTimestamp());
                ymdEntity.set市町村コード(entity.getShichosonCode());
                ymdEntity.set年度内連番(entity.getNendoNaiRenban());
                対象終了日時リスト.add(new TaishoShuryoYmd(ymdEntity));
            }
        }
        return 対象終了日時リスト;
    }
}
