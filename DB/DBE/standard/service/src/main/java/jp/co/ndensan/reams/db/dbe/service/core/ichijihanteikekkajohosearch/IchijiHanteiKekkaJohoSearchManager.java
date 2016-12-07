/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ichijihanteikekkajohosearch;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchMapper;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.ninteishinseijoho.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 一次判定結果情報取得クラスです。
 *
 * @reamsid_L DBE-3000-240 wangjie2
 */
public class IchijiHanteiKekkaJohoSearchManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    IchijiHanteiKekkaJohoSearchManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 一次判定結果情報取得ManagerのIntanceを作成します。
     *
     * @return IchijiHanteiKekkaJohoSearchManager
     */
    public static IchijiHanteiKekkaJohoSearchManager createIntance() {
        return InstanceProvider.create(IchijiHanteiKekkaJohoSearchManager.class);
    }

    @Transaction
    public RString get一次判定引数(ShinseishoKanriNo 申請書管理番号) {
        if (null == 申請書管理番号 || 申請書管理番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("申請書管理番号"));
        }
        Code 厚労省IF識別コード = get厚労省IF識別コード(申請書管理番号);
        if (!KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())
                && !KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
            throw new ApplicationException(DbeErrorMessages.一次判定実行不可.getMessage());
        }

        List<RString> 基本調査項目List = get基本調査項目(申請書管理番号);
        List<RString> 主治医意見書項目List = get主治医意見書項目(申請書管理番号);

        RString 基本調査項目 = join(基本調査項目List);
        RString 主治医意見書項目 = join(主治医意見書項目List);

        DbT4203NinteichosahyoKihonChosaEntity 認定調査票_基本調査 = get認定調査票_基本調査(申請書管理番号);
        RString 障害高齢者自立度 = RString.EMPTY;
        RString 認知症高齢者自立度 = RString.EMPTY;
        if (認定調査票_基本調査 != null) {
            Code 障害高齢者自立度コード = 認定調査票_基本調査.getShogaiNichijoSeikatsuJiritsudoCode();
            Code 認知症高齢者自立度コード = 認定調査票_基本調査.getNinchishoNichijoSeikatsuJiritsudoCode();
            障害高齢者自立度 = 障害高齢者自立度コード == null ? RString.EMPTY : 障害高齢者自立度コード.getColumnValue();
            認知症高齢者自立度 = 障害高齢者自立度コード == null ? RString.EMPTY : 認知症高齢者自立度コード.getColumnValue();
        }
        RString 認知症高齢者自立度_主治医意見書 = get認知症高齢者自立度_主治医意見書(申請書管理番号);

        RStringBuilder builder = new RStringBuilder();
        builder.append(testData(基本調査項目, 74));
        builder.append(",");
        builder.append(testData(主治医意見書項目, 4));
        builder.append(",");
        builder.append(testData(障害高齢者自立度, 1));
        builder.append(",");
        builder.append(testData(認知症高齢者自立度, 1));
        builder.append(",");
        builder.append(testData(認知症高齢者自立度_主治医意見書, 1));

        return builder.toRString();
    }

    //TODO n8178 城間 本来はデータが無い場合に代わりの値を詰めたりはしないはず。後でtestDataメソッドは削除する。
    private RString testData(RString str, int num) {
        if (str.length() == num) {
            return str;
        }
        RStringBuilder builder = new RStringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append("1");
        }
        return builder.toRString();
    }

    private RString join(List<RString> list) {
        if (list == null) {
            return RString.EMPTY;
        }

        RStringBuilder builder = new RStringBuilder();
        for (RString str : list) {
            builder.append(str);
        }
        return builder.toRString();
    }

    //TODO n8178 不要か判断した後削除する。（一次判定は行えない以上不要と思われるが、別処理でも利用されているので現状は残している）
    /**
     * 被保険者編集
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 一次判定結果情報
     * @throws ApplicationException ①
     * 入力パラメータ.申請書管理番号がない場合、UrErrorMessages.必須(引数：申請書管理番号)を投ける
     * @throws ApplicationException ②
     * 厚労省IF識別コードが'09A'または'09B'以外の場合、DbErrorMessages.一次判定実行不可を投ける。
     */
    @Transaction
    public IchijiHanteiKekkaJohoSearchBusiness getIchijiHanteiKekkaJoho(ShinseishoKanriNo 申請書管理番号) {
        IchijiHanteiKekkaJohoSearchMapper mapper = mapperProvider.create(IchijiHanteiKekkaJohoSearchMapper.class);
        if (null == 申請書管理番号 || 申請書管理番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("申請書管理番号"));
        }
        IchijiHanteiKekkaJohoSearchEntity 一次判定結果情報Entity = new IchijiHanteiKekkaJohoSearchEntity();
        Code 厚労省IF識別コード = get厚労省IF識別コード(申請書管理番号);
        if (!KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())
                && !KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
            throw new ApplicationException(DbeErrorMessages.一次判定実行不可.getMessage());
        }
        一次判定結果情報Entity.set厚労省IF識別コード(厚労省IF識別コード);
        //TODO 組み込み関数  QA79385  今回の実装はTODOとしてください  checkstyleので、以下sourceは注釈しました
        List<RString> 基本調査項目List = get基本調査項目(申請書管理番号);
        List<RString> 主治医意見書項目List = get主治医意見書項目(申請書管理番号);
        DbT4203NinteichosahyoKihonChosaEntity 認定調査票_基本調査 = get認定調査票_基本調査(申請書管理番号);
        Code 障害高齢者自立度 = 認定調査票_基本調査.getShogaiNichijoSeikatsuJiritsudoCode();
        Code 認知症高齢者自立度 = 認定調査票_基本調査.getNinchishoNichijoSeikatsuJiritsudoCode();
        RString 認知症高齢者自立度_主治医意見書 = get認知症高齢者自立度_主治医意見書(申請書管理番号);

        int 認定調査票_基本調査件数 = mapper.get認定調査票_基本調査件数(申請書管理番号);
        int 要介護認定主治医意見書情報件数 = mapper.get要介護認定主治医意見書情報件数(申請書管理番号);
        一次判定結果情報Entity.set認定調査票_基本調査_件数(認定調査票_基本調査件数);
        一次判定結果情報Entity.set要介護認定主治医意見書情報件数(要介護認定主治医意見書情報件数);
        return new IchijiHanteiKekkaJohoSearchBusiness(一次判定結果情報Entity);
    }

    private RString get認知症高齢者自立度_主治医意見書(ShinseishoKanriNo 申請書管理番号) {
        IchijiHanteiKekkaJohoSearchMapper mapper = mapperProvider.create(IchijiHanteiKekkaJohoSearchMapper.class);
        List<DbT4304ShujiiIkenshoIkenItemEntity> dbT4304EntityList = mapper.get認知症高齢者自立度_主治医意見書(申請書管理番号);
        if (null == dbT4304EntityList || dbT4304EntityList.isEmpty()) {
            return RString.EMPTY;
        } else {
            return dbT4304EntityList.get(0).getIkenItem();
        }
    }

    private DbT4203NinteichosahyoKihonChosaEntity get認定調査票_基本調査(ShinseishoKanriNo 申請書管理番号) {
        IchijiHanteiKekkaJohoSearchMapper mapper = mapperProvider.create(IchijiHanteiKekkaJohoSearchMapper.class);
        List<DbT4203NinteichosahyoKihonChosaEntity> dbT4203EntityList = mapper.get認定調査票_基本調査(申請書管理番号);
        if (null == dbT4203EntityList || dbT4203EntityList.isEmpty()) {
            return new DbT4203NinteichosahyoKihonChosaEntity();
        } else {
            return dbT4203EntityList.get(0);
        }
    }

    private List<RString> get基本調査項目(ShinseishoKanriNo 申請書管理番号) {
        IchijiHanteiKekkaJohoSearchMapper mapper = mapperProvider.create(IchijiHanteiKekkaJohoSearchMapper.class);
        List<RString> 基本調査項目List = new ArrayList<>();
        List<DbT5211NinteichosahyoChosaItemEntity> dbT5211Entity = mapper.get基本調査項目(申請書管理番号);
        for (DbT5211NinteichosahyoChosaItemEntity entity : dbT5211Entity) {
            基本調査項目List.add(entity.getResearchItem());
        }
        return 基本調査項目List;
    }

    private List<RString> get主治医意見書項目(ShinseishoKanriNo 申請書管理番号) {
        IchijiHanteiKekkaJohoSearchMapper mapper = mapperProvider.create(IchijiHanteiKekkaJohoSearchMapper.class);
        List<RString> 主治医意見書項目List = new ArrayList<>();
        List<DbT4304ShujiiIkenshoIkenItemEntity> dbT4304Entity = mapper.get主治医意見書項目(申請書管理番号);
        for (DbT4304ShujiiIkenshoIkenItemEntity entity : dbT4304Entity) {
            主治医意見書項目List.add(entity.getIkenItem());
        }
        return 主治医意見書項目List;
    }

    private Code get厚労省IF識別コード(ShinseishoKanriNo 申請書管理番号) {
        NinteiShinseiJohoManager ninteiShinseiJohoManager = new NinteiShinseiJohoManager();
        NinteiShinseiJoho2 ninteiShinseiJoho = ninteiShinseiJohoManager.get要介護認定申請情報(申請書管理番号);
        if (null == ninteiShinseiJoho) {
            return Code.EMPTY;
        } else {
            return ninteiShinseiJoho.get厚労省IF識別コード();
        }
    }

}
