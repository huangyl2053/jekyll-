/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD511002.DBD511002_KoshinOshiraseTsuchiParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001.KoshinTaishoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001.KoshinTaishoDivSpec;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.koshinTaisho.SelectSyuuShadeTaEntity;
import jp.co.ndensan.reams.db.dbd.service.core.koshinTaisho.KoshinTaishoFinder;
import jp.co.ndensan.reams.db.dbd.service.core.koshinTaisho.KoshinTaishoManager;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKikanKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.AutoWaritsukeFlag;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.MobileDataShutsuryokuFlag;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のバリデーションハンドラークラスです。
 *
 * @author_L DBD-2030-010 x_youyj
 */
public class KoshinTaishoValidationHandler {

    private RString 申請書管理番号 = new RString("");
    private static final RString 横木 = new RString("-");
    private static final RString 九九A = new RString("99A");
    private static final RString ZRROTWOA = new RString("02A");
    private static final RString ZRROSIXA = new RString("06A");
    private static final RString ZRRONINEA = new RString("09A");
    private static final RString ZRRONINEB = new RString("09B");
    private static final int ZEOR = 0;
    private static final int THRR = 3;
    private static final int SIX = 6;
    private static final int TWO = 2;

    /**
     * 更新管理完了対象者一覧データの存在チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinTaishoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 更新管理完了対象者一覧データの存在チェック(
            ValidationMessageControlPairs pairs, KoshinTaishoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinTaishoDivSpec.更新管理完了対象者一覧データの存在チェック)
                .thenAdd(NoInputMessages.存在チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.存在チェック, div).build().check(messages));
        return pairs;
    }

    /**
     * 更新管理完了対象者一覧データの行選択チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinTaishoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 更新管理完了対象者一覧データの行選択チェック(
            ValidationMessageControlPairs pairs, KoshinTaishoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinTaishoDivSpec.更新管理完了対象者一覧データの行選択チェック)
                .thenAdd(NoInputMessages.行選択チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.行選択チェック, div).build().check(messages));
        return pairs;
    }

    /**
     * 更新管理完了対象者一覧選択行の完了処理事前チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinTaishoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 更新管理完了対象者一覧選択行の完了処理事前チェック(
            ValidationMessageControlPairs pairs, KoshinTaishoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinTaishoDivSpec.更新管理完了対象者一覧選択行の完了処理事前チェック)
                .thenAdd(NoInputMessages.完了処理事前チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.完了処理事前チェック, div).build().check(messages));
        return pairs;
    }

    /**
     * 調査データ（モバイル用）の作成を行う
     *
     * @param div KoshinTaishoDiv
     * @return List<selectSyuuShadeTaEntity>
     */
    public List<SelectSyuuShadeTaEntity> csvSyuShayou(KoshinTaishoDiv div) {
        int count = 0;
        for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getCheckbox()) {
            if (row.getShinseishoKanriNo() != null) {
                if (count == 0) {
                    申請書管理番号 = row.getShinseishoKanriNo();
                    count++;
                } else {
                    申請書管理番号 = new RString(申請書管理番号 + "," + row.getShinseishoKanriNo());
                }
            }
        }
        return KoshinTaishoFinder.createInstance().get調査データの取得(申請書管理番号);
    }

    /**
     * 認定調査依頼情報のモバイルデータ出力済フラグを出力済みで更新する。
     *
     * @param div KoshinTaishoDiv
     */
    public void koushiDb(KoshinTaishoDiv div) {
        for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getCheckbox()) {
            DbT4201NinteichosaIraiJohoEntity 認定調査依頼情報 = KoshinTaishoFinder
                    .createInstance().get認定調査依頼情報の取得(row.getShinseishoKanriNo());
            if (認定調査依頼情報 != null) {
                認定調査依頼情報.setMobileDataShutsuryokuZumiFlag(MobileDataShutsuryokuFlag.出力済.isモバイルデータ出力());
                KoshinTaishoManager manger = KoshinTaishoManager.createInstance();
                manger.updateDbt4201johon(認定調査依頼情報);
            }
        }
    }

    /**
     * バッチパラメータを設定、バッチ起動を起動します。
     *
     * @param div KoshinTaishoDiv
     * @param parameter DBD511002_KoshinOshiraseTsuchiParameter
     */
    public void onCilck_btnBatchRegister(DBD511002_KoshinOshiraseTsuchiParameter parameter, KoshinTaishoDiv div) {
        List<RString> 申請書管理番号リスト = new ArrayList<>();
        for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getCheckbox()) {
            申請書管理番号リスト.add(row.getShinseishoKanriNo());
        }
        RString 出力対象区分;
        if (div.getChkOutPutSelect().getSelectedKeys().size() == 1) {
            if (new RString("0").equals(div.getChkOutPutSelect().getSelectedKeys().get(0))) {
                出力対象区分 = new RString("0");
            } else {
                出力対象区分 = new RString("1");
            }
        } else {
            出力対象区分 = new RString("2");
        }
        FlexibleDate 抽出対象期間_開始 = div.getTxtKikan().getMinDate().toFlexibleDate();
        FlexibleDate 抽出対象期間_終了 = div.getTxtKikan().getMaxDate().toFlexibleDate();
        FlexibleDate 通知書発行日 = div.getTxtHakobi().getValue();
        if (div.getCcdChohyoShutsuryokuJun().getSelected出力順() != null) {
            parameter.set出力順(new RString(div.getCcdChohyoShutsuryokuJun().getSelected出力順().toString()));
        }
        parameter.set出力対象区分(出力対象区分);
        parameter.set抽出対象期間_終了(抽出対象期間_終了);
        parameter.set抽出対象期間_開始(抽出対象期間_開始);
        parameter.set申請書管理番号リスト(申請書管理番号リスト);
        parameter.set通知書発行日(通知書発行日);
    }

    /**
     * 要介護認定申請情報の取得する。
     *
     * @param div KoshinTaishoDiv
     */
    public void youKihoKoushiDb(KoshinTaishoDiv div) {
        for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getCheckbox()) {
            List<DbT4101NinteiShinseiJohoEntity> 認定申請情報List = KoshinTaishoFinder
                    .createInstance().get要介護認定申請情報の取得(row.getShinseishoKanriNo());
            if (認定申請情報List != null) {
                for (DbT4101NinteiShinseiJohoEntity entity : 認定申請情報List) {
                    entity.setNinteiShinseiShinseijiKubunCode(new Code(NinteiShinseiShinseijiKubunCode.更新申請.getコード()));
                    entity.setKoshinTsuchiHakkoKanryoYMD(new FlexibleDate(RDate.getNowDate().toDateString()));
                    KoshinTaishoManager manger = KoshinTaishoManager.createInstance();
                    manger.updateDbt4101johon(entity);
                }
            }
        }
    }

    /**
     * アクセスログ情報を作成する。
     *
     * @param div KoshinTaishoDiv
     * @return List<PersonalData>
     */
    public List<PersonalData> アクセスログ情報(KoshinTaishoDiv div) {
        List<PersonalData> personalDataList = new ArrayList<>();
        PersonalData personalData;
        for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getDataSource()) {
            personalData = PersonalData.of(ShikibetsuCode.EMPTY,
                    new ExpandedInformation(
                            new Code("0001"),
                            new RString("申請書管理番号"),
                            row.getShinseishoKanriNo()));
            personalDataList.add(personalData);
            personalData = PersonalData.of(ShikibetsuCode.EMPTY,
                    new ExpandedInformation(
                            new Code("0002"),
                            new RString("証記載保険者番号"),
                            row.getKaisaiNumber()));
            personalDataList.add(personalData);
            personalData = PersonalData.of(ShikibetsuCode.EMPTY,
                    new ExpandedInformation(
                            new Code("0003"),
                            new RString("被保険者番号"),
                            row.getHihoNumber()));
            personalDataList.add(personalData);
        }
        return personalDataList;
    }

    /**
     * 調査データ（モバイル用）を出力編集仕様
     *
     * @param sqlEntity SelectSyuuShadeTaEntity
     * @return SelectSyuuShadeTaEntity
     */
    public SelectSyuuShadeTaCsvEntity setdetaEntity(SelectSyuuShadeTaEntity sqlEntity) {
        SelectSyuuShadeTaCsvEntity entity = new SelectSyuuShadeTaCsvEntity();
        entity.set厚労省認定ソフトのバージョン(KoroshoIfShikibetsuCode.toValue(sqlEntity.get厚労省IF識別コード()).get名称());
        if (sqlEntity.get認定申請年月日() != null) {
            entity.set認定申請年月日(new FlexibleDate(sqlEntity.get認定申請年月日().wareki().toString()));
        }
        entity.set認定申請区分申請時(NinteiShinseiShinseijiKubunCode.toValue(sqlEntity.get認定申請区分申請時コード()).get名称());
        if (sqlEntity.get生年月日() != null) {
            entity.set生年月日(new FlexibleDate(sqlEntity.get生年月日().wareki().toString()));
        }
        entity.set性別(Seibetsu.toValue(sqlEntity.get性別()).get名称());
        if (sqlEntity.get郵便番号() != null) {
            RString three = sqlEntity.get郵便番号().substring(ZEOR, TWO);
            RString four = sqlEntity.get郵便番号().substring(THRR, SIX);
            entity.set郵便番号(three.concat(横木).concat(four));
        }
        if (sqlEntity.get認定調査依頼完了年月日() != null) {
            entity.set認定調査依頼完了年月日(new FlexibleDate(sqlEntity.get認定調査依頼完了年月日().wareki().toString()));
        }
        if (sqlEntity.get委託先の郵便番号() != null) {
            RString three = sqlEntity.get委託先の郵便番号().substring(ZEOR, TWO);
            RString four = sqlEntity.get委託先の郵便番号().substring(THRR, SIX);
            entity.set委託先の郵便番号(three.concat(横木).concat(four));
        }
        entity.set委託先の調査委託区分(ChosaItakuKubunCode.toValue(sqlEntity.get委託先の調査委託区分()).get名称());
        entity.set委託先の自動割付名称(AutoWaritsukeFlag.toValue(sqlEntity.is委託先の自動割付フラグ()).get名称());
        entity.set委託先の機関の区分(ChosaKikanKubun.toValue(sqlEntity.get委託先の機関の区分()).get名称());
        entity.set調査員の性別(Seibetsu.toValue(sqlEntity.get調査員の性別()).get名称());
        entity.set調査員の調査員資格(Sikaku.toValue(sqlEntity.get調査員の調査員資格()).get名称());
        if (sqlEntity.get調査員の郵便番号() != null) {
            RString three = sqlEntity.get調査員の郵便番号().substring(ZEOR, TWO);
            RString four = sqlEntity.get調査員の郵便番号().substring(THRR, SIX);
            entity.set調査員の郵便番号(three.concat(横木).concat(four));
        }
        entity.set概況特記テキストイメージ区分(TokkijikoTextImageKubun.toValue(sqlEntity.get概況特記テキストイメージ区分コード()).get名称());
        entity.set認定調査依頼区分(NinteiChousaIraiKubunCode.toValue(sqlEntity.get認定調査依頼区分コード()).get名称());
        if (sqlEntity.get認定調査実施年月日() != null) {
            entity.set認定調査実施年月日(new FlexibleDate(sqlEntity.get認定調査実施年月日().wareki().toString()));
        }
        if (sqlEntity.get認定調査受領年月日() != null) {
            entity.set認定調査受領年月日(new FlexibleDate(sqlEntity.get認定調査受領年月日().wareki().toString()));
        }
        entity.set認定調査区分(ChosaKubun.toValue(sqlEntity.get認定調査区分コード()).get名称());
        entity.set認定調査実施場所(ChosaJisshiBashoCode.toValue(sqlEntity.get認定調査実施場所コード()).get名称());
        entity.set認定調査サービス区分(ServiceKubunCode.toValue(sqlEntity.get認定調査サービス区分コード()).get名称());
        if (sqlEntity.get利用施設郵便番号() != null) {
            RString three = sqlEntity.get利用施設郵便番号().substring(ZEOR, TWO);
            RString four = sqlEntity.get利用施設郵便番号().substring(THRR, SIX);
            entity.set利用施設郵便番号(three.concat(横木).concat(four));
        }
        if (sqlEntity.get認定調査特記事項受付年月日() != null) {
            entity.set認定調査特記事項受付年月日(new FlexibleDate(sqlEntity.get認定調査特記事項受付年月日().wareki().toString()));
        }
        if (sqlEntity.get認定調査特記事項受領年月日() != null) {
            entity.set認定調査特記事項受領年月日(new FlexibleDate(sqlEntity.get認定調査特記事項受領年月日().wareki().toString()));
        }
        entity.set原本マスク区分(GenponMaskKubun.toValue(sqlEntity.get原本マスク区分コード()).get名称());
        entity.set認定調査認知症高齢者の日常生活自立度(NinchishoNichijoSeikatsuJiritsudoCode.toValue(
                sqlEntity.get認定調査認知症高齢者の日常生活自立度コード()).get名称());
        entity.set認定調査障害高齢者の日常生活自立度(ShogaiNichijoSeikatsuJiritsudoCode.toValue(
                sqlEntity.get認定調査障害高齢者の日常生活自立度コード()).get名称());
        if (九九A.equals(sqlEntity.get厚労省IF識別コード())) {
            entity.set調査項目文言(NinteichosaKomokuMapping99A.toValue(sqlEntity.get調査項目連番()).get名称());
        } else if (ZRROTWOA.equals(sqlEntity.get厚労省IF識別コード())) {
            entity.set調査項目文言(NinteichosaKomokuMapping02A.toValue(sqlEntity.get調査項目連番()).get名称());
        } else if (ZRROSIXA.equals(sqlEntity.get厚労省IF識別コード())) {
            entity.set調査項目文言(NinteichosaKomokuMapping06A.toValue(sqlEntity.get調査項目連番()).get名称());
        } else if (ZRRONINEA.equals(sqlEntity.get厚労省IF識別コード())) {
            entity.set調査項目文言(NinteichosaKomokuMapping09A.toValue(sqlEntity.get調査項目連番()).get名称());
        } else if (ZRRONINEB.equals(sqlEntity.get厚労省IF識別コード())) {
            entity.set調査項目文言(NinteichosaKomokuMapping09B.toValue(sqlEntity.get調査項目連番()).get名称());
        }
        setVoidEntity(entity, sqlEntity);
        return entity;
    }

    /**
     * 一覧を出力の引数
     *
     * @param csvEntity koshinTaishoEntity
     * @param row dgNinteiTaskList_Row
     * @return koshinTaishoEntity
     */
    public KoshinTaishoCsvEntity setCsvEntity(KoshinTaishoCsvEntity csvEntity, dgNinteiTaskList_Row row) {
        csvEntity.set保険者(row.getHokensha());
        csvEntity.set被保番号(row.getNyuryokuHoho());
        csvEntity.set氏名(row.getHihoShimei());
        if (row.getCenterSoshinDay().getValue() != null) {
            csvEntity.set完了日(row.getCenterSoshinDay().getValue().wareki().toDateString());
        }
        if (row.getChosahyoDataNyuryokuDay().getValue() != null) {
            csvEntity.set通知年月日(row.getChosahyoDataNyuryokuDay().getValue().wareki().toDateString());
        }
        return csvEntity;
    }

    private void setVoidEntity(SelectSyuuShadeTaCsvEntity entity, SelectSyuuShadeTaEntity sqlEntity) {
        entity.set申請書管理番号(sqlEntity.get申請書管理番号());
        entity.set厚労省IF識別コード(sqlEntity.get厚労省IF識別コード());
        entity.set証記載保険者番号(sqlEntity.get証記載保険者番号());
        entity.set認定申請区分申請時コード(sqlEntity.get認定申請区分申請時コード());
        entity.set被保険者氏名(sqlEntity.get被保険者氏名());
        entity.set被保険者氏名カナ(sqlEntity.get被保険者氏名カナ());
        entity.set年齢(sqlEntity.get年齢());
        entity.set住所(sqlEntity.get住所());
        entity.set電話番号(sqlEntity.get電話番号());
        entity.set保険者名(sqlEntity.get保険者名());
        entity.set認定調査依頼履歴番号(sqlEntity.get認定調査依頼履歴番号());
        entity.set認定調査委託先コード(sqlEntity.get認定調査委託先コード());
        entity.set調査委託先(sqlEntity.get調査委託先());
        entity.set委託先の事業者名称カナ(sqlEntity.get委託先の事業者名称カナ());
        entity.set委託先の住所(sqlEntity.get委託先の住所());
        entity.set委託先の電話番号(sqlEntity.get委託先の電話番号());
        entity.set委託先のFAX番号(sqlEntity.get委託先のFAX番号());
        entity.set委託先の代表者名(sqlEntity.get委託先の代表者名());
        entity.set委託先の代表者名カナ(sqlEntity.get委託先の代表者名カナ());
        entity.set委託先の割付定員(sqlEntity.get委託先の割付定員());
        entity.set委託先の特定調査員表示フラグ(sqlEntity.is委託先の特定調査員表示フラグ());
        entity.set委託先の割付定員(sqlEntity.get委託先の割付定員());
        entity.set委託先の割付地区(sqlEntity.get委託先の割付地区());
        entity.set認定調査員コード(sqlEntity.get認定調査員コード());
        entity.set調査員氏名(sqlEntity.get調査員氏名());
        entity.set調査員の調査員氏名カナ(sqlEntity.get調査員の調査員氏名カナ());
        entity.set調査員の地区コード(sqlEntity.get調査員の地区コード());
        entity.set調査員の調査可能人数月(sqlEntity.get調査員の調査可能人数月());
        entity.set調査員の住所(sqlEntity.get調査員の住所());
        entity.set調査員の電話番号(sqlEntity.get調査員の電話番号());
        entity.set調査員のFAX番号(sqlEntity.get調査員のFAX番号());
        entity.set調査員の所属機関名称(sqlEntity.get調査員の所属機関名称());
        entity.set概況特記テキストイメージ区分コード(sqlEntity.get概況特記テキストイメージ区分コード());
        entity.set認定調査依頼区分コード(sqlEntity.get認定調査依頼区分コード());
        entity.set認定調査回数(sqlEntity.get認定調査回数());
        entity.set認定調査区分コード(sqlEntity.get認定調査区分コード());
        entity.set認定調査実施場所コード(sqlEntity.get認定調査実施場所コード());
        entity.set認定調査実施場所名称(sqlEntity.get認定調査実施場所名称());
        entity.set認定調査サービス区分コード(sqlEntity.get認定調査サービス区分コード());
        entity.set利用施設名(sqlEntity.get利用施設名());
        entity.set利用施設住所(sqlEntity.get利用施設住所());
        entity.set利用施設電話番号(sqlEntity.get利用施設電話番号());
        entity.set特記(sqlEntity.get特記());
        entity.set住宅改修改修箇所(sqlEntity.get住宅改修改修箇所());
        entity.set市町村特別給付サービス種類名(sqlEntity.get市町村特別給付サービス種類名());
        entity.set介護保険給付以外の在宅サービス種類名(sqlEntity.get介護保険給付以外の在宅サービス種類名());
        entity.set概況特記事項主訴(sqlEntity.get概況特記事項主訴());
        entity.set概況特記事項家族状況(sqlEntity.get概況特記事項家族状況());
        entity.set概況特記事項居住環境(sqlEntity.get概況特記事項居住環境());
        entity.set概況特記事項機器器械(sqlEntity.get概況特記事項機器器械());
        entity.set認定調査特記事項番号(sqlEntity.get認定調査特記事項番号());
        entity.set認定調査特記事項連番(sqlEntity.get認定調査特記事項連番());
        entity.set原本マスク区分コード(sqlEntity.get原本マスク区分コード());
        entity.set特記事項(sqlEntity.get特記事項());
        entity.setサービスの状況連番(sqlEntity.getサービスの状況連番());
        entity.setサービスの状況(sqlEntity.getサービスの状況());
        entity.setサービスの状況フラグ連番(sqlEntity.getサービスの状況フラグ連番());
        entity.setサービスの状況フラグ(sqlEntity.getサービスの状況フラグ());
        entity.set記入項目連番(sqlEntity.get記入項目連番());
        entity.setサービスの状況記入(sqlEntity.getサービスの状況記入());
        entity.set施設利用連番(sqlEntity.get施設利用連番());
        entity.set施設利用フラグ(sqlEntity.get施設利用フラグ());
        entity.set認定調査認知症高齢者の日常生活自立度コード(sqlEntity.get認定調査認知症高齢者の日常生活自立度コード());
        entity.set認定調査障害高齢者の日常生活自立度コード(sqlEntity.get認定調査障害高齢者の日常生活自立度コード());
        entity.set調査項目連番(sqlEntity.get調査項目連番());
        entity.set内容(sqlEntity.get内容());
    }

    private static enum NoInputMessages implements IValidationMessage {

        存在チェック(UrErrorMessages.該当データなし.getMessage()),
        行選択チェック(UrErrorMessages.対象行を選択.getMessage()),
        完了処理事前チェック(UrErrorMessages.更新不可_汎用.getMessage(), "通知年月日が未設定");
        private final Message message;

        private NoInputMessages(Message message, String... replacements) {
            this.message = message.replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
