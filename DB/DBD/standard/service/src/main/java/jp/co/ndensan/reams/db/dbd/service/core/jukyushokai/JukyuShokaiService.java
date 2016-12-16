/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.jukyushokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.jukyushokai.JukyuShokaiShinseiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.jukyushokai.JukyuShokaiShinseiNinteiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.jukyushokai.ServiceJukyuJokyo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushokai.JukyuShokaiShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushokai.JukyuShokaiShinseiNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushokai.ServiceJukyuJokyoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushokai.IJukyushaShokaiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.SakujoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteichosajokyo.NinteiChosaJokyoDataPassEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給照会（画面）のビジネス処理です。
 *
 * @reamsid_L DBD-3560-011 xuyue
 */
public class JukyuShokaiService {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    JukyuShokaiService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JukyuShokaiService}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link JukyuShokaiService}のインスタンス
     */
    public static JukyuShokaiService createInstance() {
        return InstanceProvider.create(JukyuShokaiService.class);
    }

    /**
     * 被保険者番号より、申請一覧情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 申請一覧情報
     */
    @Transaction
    public List<JukyuShokaiShinseiJoho> find申請情報(HihokenshaNo 被保険者番号) {
        IJukyushaShokaiMapper mapper = mapperProvider.create(IJukyushaShokaiMapper.class);
        RString 削除事由コード = SakujoJiyuCode.過誤による削除.getコード();
        List<JukyuShokaiShinseiEntity> 申請情報EntityList = mapper.find申請情報(被保険者番号, 削除事由コード);
        if (申請情報EntityList == null) {
            申請情報EntityList = new ArrayList<>();
        }

        List<JukyuShokaiShinseiJoho> johoList = new ArrayList<>();
        JukyuShokaiShinseiJoho joho;
        for (JukyuShokaiShinseiEntity entity : 申請情報EntityList) {
            joho = new JukyuShokaiShinseiJoho(entity.get受給者台帳Entity(), entity.get要介護認定インターフェース情報Entity(), entity.get厚労省IF識別コード());
            johoList.add(joho);
        }
        return johoList;
    }

    /**
     * 申請書管理番号より、申請認定情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 履歴番号 履歴番号
     * @param 枝番 枝番
     * @param 受給申請事由 受給申請事由
     * @param 被保険者番号 被保険者番号
     * @return 申請認定一覧情報
     */
    @Transaction
    public List<JukyuShokaiShinseiNinteiJoho> find申請認定情報(RString 市町村コード,
            RString 履歴番号, RString 枝番, RString 受給申請事由, RString 被保険者番号) {
        IJukyushaShokaiMapper mapper = mapperProvider.create(IJukyushaShokaiMapper.class);
        List<JukyuShokaiShinseiNinteiEntity> 申請認定情報EntityList = mapper.find申請認定情報(市町村コード, 履歴番号, 枝番, 受給申請事由, 被保険者番号);
        if (申請認定情報EntityList == null) {
            申請認定情報EntityList = new ArrayList<>();
        }

        List<JukyuShokaiShinseiNinteiJoho> johoList = new ArrayList<>();
        JukyuShokaiShinseiNinteiJoho joho;
        for (JukyuShokaiShinseiNinteiEntity entity : 申請認定情報EntityList) {
            joho = new JukyuShokaiShinseiNinteiJoho(entity);
            johoList.add(joho);
        }
        return johoList;
    }

    /**
     * 被保険者番号より、利用者負担割合情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 利用者負担割合情報
     */
    @Transaction
    public RiyoshaFutanWariaiMeisai get利用者負担割合(HihokenshaNo 被保険者番号) {
        IJukyushaShokaiMapper mapper = mapperProvider.create(IJukyushaShokaiMapper.class);
        DbT3114RiyoshaFutanWariaiMeisaiEntity 利用者負担割合明細 = mapper.get利用者負担割合(被保険者番号);
        if (利用者負担割合明細 == null) {
            利用者負担割合明細 = new DbT3114RiyoshaFutanWariaiMeisaiEntity();
        }
        return new RiyoshaFutanWariaiMeisai(利用者負担割合明細);
    }

    /**
     * 被保険者番号より、各種減免・減額、施設入退、生保・老齢・医療保険・非課税年金の受給、<br />
     * 居宅計画の届出、総合事業サービス利用の有無を調査し、結果を返却します。
     *
     * @param 被保険者番号 被保険者番号
     * @return サービス受給状況
     */
    @Transaction
    public ServiceJukyuJokyo findサービス受給状況(HihokenshaNo 被保険者番号) {
        IJukyushaShokaiMapper mapper = mapperProvider.create(IJukyushaShokaiMapper.class);
        ServiceJukyuJokyoEntity サービス受給状況 = mapper.findサービス受給状況(被保険者番号);
        return new ServiceJukyuJokyo(サービス受給状況);
    }

    /**
     * 初期化情報情報の検索
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 認定日 FlexibleDate
     * @return List<NinteiChosaJokyoDataPass>
     */
    @Transaction
    public List<NinteiChosaJokyoDataPass> get履歴情報(HihokenshaNo 被保険者番号, FlexibleDate 認定日) {

        IJukyushaShokaiMapper mapper = InstanceProvider.create(MapperProvider.class).create(IJukyushaShokaiMapper.class);

        List<NinteiChosaJokyoDataPassEntity> result = mapper.get履歴情報(被保険者番号, 認定日);

        List<NinteiChosaJokyoDataPass> returnList = new ArrayList<>();
        for (NinteiChosaJokyoDataPassEntity entity : result) {
            NinteiChosaJokyoDataPass dataPass = new NinteiChosaJokyoDataPass();
            dataPass.set主治医コード(entity.get主治医コード());
            dataPass.set主治医住所(entity.get主治医住所());
            dataPass.set主治医医療機関コード(entity.get主治医医療機関コード());
            dataPass.set主治医意見書作成依頼年月日(new RDate(entity.get主治医意見書作成依頼年月日().getYearValue(),
                    entity.get主治医意見書作成依頼年月日().getMonthValue(), entity.get主治医意見書作成依頼年月日().getDayValue()));
            dataPass.set主治医意見書登録予定年月日(new RDate(entity.get主治医意見書登録予定年月日().getYearValue(),
                    entity.get主治医意見書登録予定年月日().getMonthValue(), entity.get主治医意見書登録予定年月日().getDayValue()));
            dataPass.set主治医意見書記入年月日(new RDate(entity.get主治医意見書記入年月日().getYearValue(),
                    entity.get主治医意見書記入年月日().getMonthValue(), entity.get主治医意見書記入年月日().getDayValue()));
            dataPass.set主治医氏名(entity.get主治医氏名());
            dataPass.set主治医郵便番号(entity.get主治医郵便番号());
            dataPass.set主治医電話番号(entity.get主治医電話番号());
            dataPass.set事業者名称(entity.get事業者名称());
            dataPass.set二次判定年月日(new RDate(entity.get二次判定年月日().getYearValue(),
                    entity.get二次判定年月日().getMonthValue(), entity.get二次判定年月日().getDayValue()));
            dataPass.set二次判定要介護状態区分コード(entity.get二次判定要介護状態区分コード());
            dataPass.set二次判定認定有効期間(entity.get二次判定認定有効期間());
            dataPass.set二次判定認定有効終了年月日(entity.get二次判定認定有効終了年月日());
            dataPass.set二次判定認定有効開始年月日(entity.get二次判定認定有効開始年月日());
            dataPass.set介護認定審査会資料作成年月日(new RDate(entity.get介護認定審査会資料作成年月日().getYearValue(),
                    entity.get介護認定審査会資料作成年月日().getMonthValue(), entity.get介護認定審査会資料作成年月日().getDayValue()));
            dataPass.set医療機関名称(entity.get医療機関名称());
            dataPass.set厚労省IF識別コード(entity.get厚労省IF識別コード());
            dataPass.set市町村コード(entity.get市町村コード());
            dataPass.set延期通知発行回数(entity.get延期通知発行回数());
            dataPass.set延期通知発行年月日(new RDate(entity.get延期通知発行年月日().getYearValue(),
                    entity.get延期通知発行年月日().getMonthValue(), entity.get延期通知発行年月日().getDayValue()));
            dataPass.set指定医フラグ(entity.is指定医フラグ());
            dataPass.set申請書管理番号(entity.get申請書管理番号());
            dataPass.set要介護認定一次判定年月日(new RDate(entity.get要介護認定一次判定年月日().getYearValue(),
                    entity.get要介護認定一次判定年月日().getMonthValue(), entity.get要介護認定一次判定年月日().getDayValue()));
            dataPass.set要介護認定一次判定結果コード(entity.get要介護認定一次判定結果コード());
            dataPass.set要介護認定一次判定結果コード_認知症加算(entity.get要介護認定一次判定結果コード_認知症加算());
            dataPass.set訪問調査先住所(entity.get訪問調査先住所());
            dataPass.set訪問調査先名称(entity.get訪問調査先名称());
            dataPass.set訪問調査先郵便番号(entity.get訪問調査先郵便番号());
            dataPass.set訪問調査先電話番号(entity.get訪問調査先電話番号());
            dataPass.set認定住所(entity.get認定住所());
            dataPass.set認定審査会予定年月日(new RDate(entity.get認定審査会予定年月日().getYearValue(),
                    entity.get認定審査会予定年月日().getMonthValue(), entity.get認定審査会予定年月日().getDayValue()));
            dataPass.set認定調査予定年月日(new RDate(entity.get認定調査予定年月日().getYearValue(),
                    entity.get認定調査予定年月日().getMonthValue(), entity.get認定調査予定年月日().getDayValue()));
            dataPass.set認定調査依頼年月日(new RDate(entity.get認定調査依頼年月日().getYearValue(),
                    entity.get認定調査依頼年月日().getMonthValue(), entity.get認定調査依頼年月日().getDayValue()));
            dataPass.set認定調査員コード(entity.get認定調査員コード());
            dataPass.set認定調査委託先コード(entity.get認定調査委託先コード());
            dataPass.set認定調査実施年月日(new RDate(entity.get認定調査実施年月日().getYearValue(),
                    entity.get認定調査実施年月日().getMonthValue(), entity.get認定調査実施年月日().getDayValue()));
            dataPass.set認定郵便番号(entity.get認定郵便番号());
            dataPass.set認定電話番号(entity.get認定電話番号());
            dataPass.set調査員氏名(entity.get調査員氏名());
            dataPass.set調査委託区分(entity.get調査委託区分());

            returnList.add(dataPass);
        }
        return returnList;
    }
}
