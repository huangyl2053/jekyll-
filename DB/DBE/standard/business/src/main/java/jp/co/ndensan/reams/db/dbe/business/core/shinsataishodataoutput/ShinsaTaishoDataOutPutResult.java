/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsataishodataoutput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsChikokuUmu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IssotaiUmu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput.ShinsaTaishoDataOutPutProcessParammeter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.CodeMasterEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.NijihanteiKekkaTorokuMobileEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.NijihanteiKekkaTorokuMobileRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.NijihanteiKekkaTorokuMobileShinsaiinEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.NijihanteiKekkaTorokuMobileShinsaiinRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.dokuji.NijiHanteiKekkaInputHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.IsShiryoSakuseiZumi;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.NinteiShinsakaiIkenShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiYukoKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 認定審査会割当委員情報（モバイル）CSVEntity設定のビジネスです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
public class ShinsaTaishoDataOutPutResult {

    /**
     * EucCsvEntityの設定メッソドです。
     *
     * @param entity entity
     * @return NinteiChosaDataOutputEucCsvEntity
     */
    public NijihanteiKekkaTorokuMobileShinsaiinEucCsvEntity setEucCsvEntity(NijihanteiKekkaTorokuMobileShinsaiinRelateEntity entity) {
        NijihanteiKekkaTorokuMobileShinsaiinEucCsvEntity eucCsvEntity = new NijihanteiKekkaTorokuMobileShinsaiinEucCsvEntity();
        eucCsvEntity.set介護認定審査会予定定員(entity.get介護認定審査会予定定員());
        eucCsvEntity.set介護認定審査会割当済み人数(entity.get介護認定審査会割当済み人数());
        eucCsvEntity.set介護認定審査会委員コード(entity.get介護認定審査会委員コード());
        eucCsvEntity.set介護認定審査会委員定員(entity.get介護認定審査会委員定員());
        eucCsvEntity.set介護認定審査会最大定員(entity.get介護認定審査会最大定員());
        eucCsvEntity.set介護認定審査会終了予定時刻(strToTime(entity.get介護認定審査会終了予定時刻()));
        eucCsvEntity.set介護認定審査会自動割当定員(entity.get介護認定審査会自動割当定員());
        eucCsvEntity.set介護認定審査会議長区分コード(entity.get介護認定審査会議長区分コード());
        eucCsvEntity.set介護認定審査会資料作成年月日(setDateFormat(entity.get介護認定審査会資料作成年月日()));
        eucCsvEntity.set介護認定審査会進捗状況(entity.get介護認定審査会進捗状況());
        eucCsvEntity.set介護認定審査会開催予定場所コード(entity.get介護認定審査会開催予定場所コード());
        eucCsvEntity.set介護認定審査会開催予定年月日(setDateFormat(entity.get介護認定審査会開催予定年月日()));
        eucCsvEntity.set介護認定審査会開催年月日(setDateFormat(entity.get介護認定審査会開催年月日()));
        eucCsvEntity.set介護認定審査会開催番号(entity.get介護認定審査会開催番号());
        eucCsvEntity.set介護認定審査会開始予定時刻(strToTime(entity.get介護認定審査会開始予定時刻()));
        eucCsvEntity.set合議体番号(entity.get合議体番号());
        if (entity.is委員出席()) {
            eucCsvEntity.set委員出席(new RString("1"));
        } else {
            eucCsvEntity.set委員出席(new RString("0"));
        }
        eucCsvEntity.set委員出席時間(strToTime(entity.get委員出席時間()));
        if (entity.is委員早退有無()) {
            eucCsvEntity.set委員早退有無(new RString("1"));
        } else {
            eucCsvEntity.set委員早退有無(new RString("0"));
        }
        eucCsvEntity.set委員退席時間(strToTime(entity.get委員退席時間()));
        if (entity.is委員遅刻有無()) {
            eucCsvEntity.set委員遅刻有無(new RString("1"));
        } else {
            eucCsvEntity.set委員遅刻有無(new RString("0"));
        }
        if (entity.is資料作成済フラグ()) {
            eucCsvEntity.set資料作成済フラグ(new RString("1"));
        } else {
            eucCsvEntity.set資料作成済フラグ(new RString("0"));
        }

        return eucCsvEntity;
    }

    /**
     * NijihanteiKekkaTorokuMobileEucCsvEntityの設定メッソドです。
     *
     * @param entity entity
     * @return NijihanteiKekkaTorokuMobileEucCsvEntity
     */
    public NijihanteiKekkaTorokuMobileEucCsvEntity setNijihanteiKekkaTorokuMobileEucCsvEntity(NijihanteiKekkaTorokuMobileRelateEntity entity) {
        NijihanteiKekkaTorokuMobileEucCsvEntity eucCsvEntity = new NijihanteiKekkaTorokuMobileEucCsvEntity();

        eucCsvEntity.set介護認定審査会開催番号(entity.get介護認定審査会開催番号());
        eucCsvEntity.set合議体番号(entity.get合議体番号());
        eucCsvEntity.set介護認定審査会開催年月日(setDateFormat(entity.get介護認定審査会開催年月日()));
        eucCsvEntity.set介護認定審査会開始時刻(entity.get介護認定審査会開始時刻());
        eucCsvEntity.set介護認定審査会終了時刻(entity.get介護認定審査会終了時刻());
        eucCsvEntity.set介護認定審査会開催場所コード(entity.get介護認定審査会開催場所コード());
        eucCsvEntity.set所要時間合計(entity.get所要時間合計());
        eucCsvEntity.set介護認定審査会実施人数(entity.get介護認定審査会実施人数());
        eucCsvEntity.set介護認定審査会審査順(entity.get介護認定審査会審査順());
        eucCsvEntity.set判定結果コード(entity.get判定結果コード());
        eucCsvEntity.set二次判定年月日(setDateFormat(entity.get二次判定年月日()));
        eucCsvEntity.set二次判定要介護状態区分コード(entity.get二次判定要介護状態区分コード());
        eucCsvEntity.set二次判定認定有効期間(entity.get二次判定認定有効期間());
        eucCsvEntity.set二次判定認定有効開始年月日(setDateFormat(entity.get二次判定認定有効開始年月日()));
        eucCsvEntity.set二次判定認定有効終了年月日(setDateFormat(entity.get二次判定認定有効終了年月日()));
        eucCsvEntity.set介護認定審査会意見(entity.get介護認定審査会意見());
        eucCsvEntity.set一次判定結果変更理由(entity.get一次判定結果変更理由());
        eucCsvEntity.set要介護状態像例コード(entity.get要介護状態像例コード());
        eucCsvEntity.set認定審査会意見種類(entity.get認定審査会意見種類());
        eucCsvEntity.set審査会メモ(entity.get審査会メモ());
        eucCsvEntity.set二次判定結果入力方法(entity.get二次判定結果入力方法());
        eucCsvEntity.set二次判定結果入力年月日(setDateFormat(entity.get二次判定結果入力年月日()));
        eucCsvEntity.set認定申請区分法令コード(entity.get認定申請区分法令コード());
        eucCsvEntity.set要介護認定1_5次判定年月日(entity.get要介護認定1_5次判定年月日());
        eucCsvEntity.set要介護認定1_5次判定結果コード(entity.get要介護認定1_5次判定結果コード());
        eucCsvEntity.set要介護認定1_5次判定結果コード認知症加算(entity.get要介護認定1_5次判定結果コード認知症加算());
        eucCsvEntity.set要介護認定等基準時間(entity.get要介護認定等基準時間());
        eucCsvEntity.set要介護認定等基準時間食事(entity.get要介護認定等基準時間食事());
        eucCsvEntity.set要介護認定等基準時間排泄(entity.get要介護認定等基準時間排泄());
        eucCsvEntity.set要介護認定等基準時間移動(entity.get要介護認定等基準時間移動());
        eucCsvEntity.set要介護認定等基準時間清潔保持(entity.get要介護認定等基準時間清潔保持());
        eucCsvEntity.set要介護認定等基準時間間接ケア(entity.get要介護認定等基準時間間接ケア());
        eucCsvEntity.set要介護認定等基準時間BPSD関連(entity.get要介護認定等基準時間BPSD関連());
        eucCsvEntity.set要介護認定等基準時間機能訓練(entity.get要介護認定等基準時間機能訓練());
        eucCsvEntity.set要介護認定等基準時間医療関連(entity.get要介護認定等基準時間医療関連());
        eucCsvEntity.set要介護認定等基準時間認知症加算(entity.get要介護認定等基準時間認知症加算());
        eucCsvEntity.set中間評価項目得点第1群(entity.get中間評価項目得点第1群());
        eucCsvEntity.set中間評価項目得点第2群(entity.get中間評価項目得点第2群());
        eucCsvEntity.set中間評価項目得点第3群(entity.get中間評価項目得点第3群());
        eucCsvEntity.set中間評価項目得点第4群(entity.get中間評価項目得点第4群());
        eucCsvEntity.set中間評価項目得点第5群(entity.get中間評価項目得点第5群());
        eucCsvEntity.set要介護認定1_5次判定警告コード(entity.get要介護認定1_5次判定警告コード());
        eucCsvEntity.set要介護認定状態の安定性コード(entity.get要介護認定状態の安定性コード());
        eucCsvEntity.set認知症自立度Ⅱ以上の蓋然性(entity.get認知症自立度Ⅱ以上の蓋然性());
        eucCsvEntity.set認知機能及び状態安定性から推定される給付区分コード(entity.get認知機能及び状態安定性から推定される給付区分コード());
        eucCsvEntity.set申請書管理番号(entity.get申請書管理番号());
        eucCsvEntity.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        if (!RString.isNullOrEmpty(entity.get厚労省IF識別コード())) {
            eucCsvEntity.set厚労省認定ソフトのバージョン(KoroshoIfShikibetsuCode.toValue(entity.get厚労省IF識別コード()).get名称());
        }
        eucCsvEntity.set証記載保険者番号(entity.get証記載保険者番号());
        eucCsvEntity.set被保険者番号(entity.get被保険者番号());
        eucCsvEntity.set認定申請年月日(setDateFormat(entity.get認定申請年月日()));
        eucCsvEntity.set認定申請区分申請時コード(entity.get認定申請区分申請時コード());
        if (!RString.isNullOrEmpty(entity.get認定申請区分申請時コード())) {
            eucCsvEntity.set認定申請区分申請時(NinteiShinseiYukoKubunCode.toValue(entity.get認定申請区分申請時コード()).get名称());
        }
        eucCsvEntity.set被保険者氏名(entity.get被保険者氏名());
        eucCsvEntity.set被保険者氏名カナ(entity.get被保険者氏名カナ());
        eucCsvEntity.set生年月日(setDateFormat(entity.get生年月日()));
        eucCsvEntity.set年齢(entity.get年齢());
        if (!RString.isNullOrEmpty(entity.get性別())) {
            eucCsvEntity.set性別(Seibetsu.toValue(entity.get性別()).get名称());
        }
        eucCsvEntity.set郵便番号(setYobuinNoFormat(entity.get郵便番号()));
        eucCsvEntity.set住所(entity.get住所());
        eucCsvEntity.set電話番号(entity.get電話番号());
        eucCsvEntity.set市町村名称(entity.get市町村名称());
        eucCsvEntity.set一次判定年月日(setDateFormat(entity.get一次判定年月日()));
        eucCsvEntity.set要介護認定一次判定結果コード(entity.get要介護認定一次判定結果コード());
        eucCsvEntity.set認定調査依頼完了年月日(setDateFormat(entity.get認定調査依頼完了年月日()));
        eucCsvEntity.set認定調査依頼履歴番号(entity.get認定調査依頼履歴番号());
        eucCsvEntity.set認定調査委託先コード(entity.get認定調査委託先コード());
        if (!RString.isNullOrEmpty(entity.get認定調査委託先コード())) {
            eucCsvEntity.set調査委託先(SaibanHanyokeyName.toValue(entity.get認定調査委託先コード()).get名称());
        }

        eucCsvEntity.set認定調査員コード(entity.get認定調査員コード());
        eucCsvEntity.set調査員氏名(entity.get調査員氏名());
        eucCsvEntity.set概況特記テキストイメージ区分コード(entity.get概況特記テキストイメージ区分コード());
        if (!RString.isNullOrEmpty(entity.get概況特記テキストイメージ区分コード())) {
            eucCsvEntity.set概況特記テキストイメージ区分(TokkijikoTextImageKubun.toValue(entity.get概況特記テキストイメージ区分コード()).get名称());
        }
        eucCsvEntity.set認定調査依頼区分コード(entity.get認定調査依頼区分コード());
        if (!RString.isNullOrEmpty(entity.get認定調査依頼区分コード())) {
            eucCsvEntity.set認定調査依頼区分(NinteiChousaIraiKubunCode.toValue(entity.get認定調査依頼区分コード()).get名称());
        }

        eucCsvEntity.set認定調査回数(entity.get認定調査回数());
        eucCsvEntity.set認定調査実施年月日(setDateFormat(entity.get認定調査実施年月日()));
        eucCsvEntity.set認定調査受領年月日(setDateFormat(entity.get認定調査受領年月日()));
        eucCsvEntity.set認定調査区分コード(entity.get認定調査区分コード());
        if (!RString.isNullOrEmpty(entity.get認定調査区分コード())) {
            eucCsvEntity.set認定調査区分(ChosaKubun.toValue(entity.get認定調査区分コード()).get名称());
        }
        eucCsvEntity.set認定調査実施場所コード(entity.get認定調査実施場所コード());
        if (!RString.isNullOrEmpty(entity.get認定調査実施場所コード())) {
            eucCsvEntity.set認定調査実施場所(ChosaJisshiBashoCode.toValue(entity.get認定調査実施場所コード()).get名称());
        }
        eucCsvEntity.set認定調査実施場所名称(entity.get認定調査実施場所名称());
        eucCsvEntity.set認定調査サービス区分コード(entity.get認定調査サービス区分コード());
        if (!RString.isNullOrEmpty(entity.get認定調査サービス区分コード())) {
            eucCsvEntity.set認定調査サービス区分(ServiceKubunCode.toValue(entity.get認定調査サービス区分コード()).get名称());
        }
        eucCsvEntity.set利用施設名(entity.get利用施設名());
        eucCsvEntity.set利用施設住所(entity.get利用施設住所());
        eucCsvEntity.set利用施設電話番号(entity.get利用施設電話番号());
        eucCsvEntity.set利用施設郵便番号(setYobuinNoFormat(entity.get利用施設郵便番号()));
        eucCsvEntity.set特記(entity.get特記());
        eucCsvEntity.set認定調査特記事項受付年月日(setDateFormat(entity.get認定調査特記事項受付年月日()));
        eucCsvEntity.set認定調査特記事項受領年月日(setDateFormat(entity.get認定調査特記事項受領年月日()));
        eucCsvEntity.set住宅改修改修箇所(entity.get住宅改修改修箇所());
        eucCsvEntity.set市町村特別給付サービス種類名(entity.get市町村特別給付サービス種類名());
        eucCsvEntity.set介護保険給付以外の在宅サービス種類名(entity.get介護保険給付以外の在宅サービス種類名());
        eucCsvEntity.set概況特記事項主訴(entity.get概況特記事項主訴());
        eucCsvEntity.set概況特記事項家族状況(entity.get概況特記事項家族状況());
        eucCsvEntity.set概況特記事項居住環境(entity.get概況特記事項居住環境());
        eucCsvEntity.set概況特記事項機器器械(entity.get概況特記事項機器器械());
        eucCsvEntity.set認定調査特記事項番号(entity.get認定調査特記事項番号());
        eucCsvEntity.set認定調査特記事項連番(entity.get認定調査特記事項連番());
        eucCsvEntity.set原本マスク区分コード(entity.get原本マスク区分コード());
        if (!RString.isNullOrEmpty(entity.get原本マスク区分コード())) {
            eucCsvEntity.set原本マスク区分(GenponMaskKubun.toValue(entity.get原本マスク区分コード()).get名称());
        }
        eucCsvEntity.set特記事項(entity.get特記事項());
        eucCsvEntity.setサービスの状況連番(entity.getサービスの状況連番());
        eucCsvEntity.setサービスの状況(entity.getサービスの状況());
        eucCsvEntity.setサービスの状況フラグ連番(entity.getサービスの状況フラグ連番());
        setEucCsvEntity(entity, eucCsvEntity);
        return eucCsvEntity;
    }

    private void setEucCsvEntity(NijihanteiKekkaTorokuMobileRelateEntity entity, NijihanteiKekkaTorokuMobileEucCsvEntity eucCsvEntity) {
        if (entity.isサービスの状況フラグ()) {
            eucCsvEntity.setサービスの状況フラグ(new RString("1"));
        } else {
            eucCsvEntity.setサービスの状況フラグ(new RString("0"));
        }
        eucCsvEntity.set記入項目連番(entity.get記入項目連番());
        eucCsvEntity.setサービスの状況記入(entity.getサービスの状況記入());
        eucCsvEntity.set施設利用連番(entity.get施設利用連番());
        if (entity.is施設利用フラグ()) {
            eucCsvEntity.set施設利用フラグ(new RString("1"));
        } else {
            eucCsvEntity.set施設利用フラグ(new RString("0"));
        }
        eucCsvEntity.set認定調査認知症高齢者の日常生活自立度コード(entity.get認定調査認知症高齢者の日常生活自立度コード());
        eucCsvEntity.set認定調査認知症高齢者の日常生活自立度(entity.get認定調査認知症高齢者の日常生活自立度());
        eucCsvEntity.set認定調査障害高齢者の日常生活自立度コード(entity.get認定調査障害高齢者の日常生活自立度コード());
        eucCsvEntity.set認定調査障害高齢者の日常生活自立度(entity.get認定調査障害高齢者の日常生活自立度());
        eucCsvEntity.set調査項目連番(entity.get調査項目連番());
        eucCsvEntity.set調査項目文言(entity.get調査項目文言());
        eucCsvEntity.set内容(entity.get内容());
    }

    /**
     * CodeMasterEucCsvEntityの設定メッソドです。
     *
     * @return List<CodeMasterEucCsvEntity>
     */
    public List<CodeMasterEucCsvEntity> getCodeMasterEucCsvEntityList() {
        List<CodeMasterEucCsvEntity> codeMasterEucCsvEntityList = new ArrayList();

        for (ShinsakaiShinchokuJokyo shinsakaiShinchokuJokyo : ShinsakaiShinchokuJokyo.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("介護認定審査会進捗状況"));
            eucCsvEntity.setコード(shinsakaiShinchokuJokyo.getコード());
            eucCsvEntity.set名称(shinsakaiShinchokuJokyo.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (KaigoninteiShinsakaiGichoKubunCode kaigonintei : KaigoninteiShinsakaiGichoKubunCode.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("介護認定審査会議長区分コード"));
            eucCsvEntity.setコード(kaigonintei.getコード());
            eucCsvEntity.set名称(kaigonintei.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }

        for (YokaigoJotaizoReiCode yokaigoJotaizoReiCode : YokaigoJotaizoReiCode.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("要介護状態像例コード"));
            eucCsvEntity.setコード(yokaigoJotaizoReiCode.getコード());
            eucCsvEntity.set名称(yokaigoJotaizoReiCode.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        setEnumClassList(codeMasterEucCsvEntityList);
        for (NinteiShinsakaiIkenShurui ninteiShinsakaiIkenShurui : NinteiShinsakaiIkenShurui.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("認定審査会意見種類"));
            eucCsvEntity.setコード(ninteiShinsakaiIkenShurui.getコード());
            eucCsvEntity.set名称(ninteiShinsakaiIkenShurui.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (NijiHanteiKekkaInputHoho nijiHanteiKekkaInputHoho : NijiHanteiKekkaInputHoho.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("二次判定結果入力方法"));
            eucCsvEntity.setコード(nijiHanteiKekkaInputHoho.getコード());
            eucCsvEntity.set名称(nijiHanteiKekkaInputHoho.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (NinteiShinseiHoreiCode ninteiShinseiHoreiCode : NinteiShinseiHoreiCode.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("申請区分（法令）コード"));
            eucCsvEntity.setコード(ninteiShinseiHoreiCode.getコード());
            eucCsvEntity.set名称(ninteiShinseiHoreiCode.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (NinteiShinseiShinseijiKubunCode ninteiShinsei : NinteiShinseiShinseijiKubunCode.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("申請区分（申請時）コード"));
            eucCsvEntity.setコード(ninteiShinsei.getコード());
            eucCsvEntity.set名称(ninteiShinsei.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (JotaiAnteiseiCode jotaiAnteiseiCode : JotaiAnteiseiCode.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("要介護認定状態の安定性コード"));
            eucCsvEntity.setコード(jotaiAnteiseiCode.getコード());
            eucCsvEntity.set名称(jotaiAnteiseiCode.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (SuiteiKyufuKubunCode suiteiKyufuKubunCode : SuiteiKyufuKubunCode.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("認知機能及び状態安定性から推定される給付区分コード"));
            eucCsvEntity.setコード(suiteiKyufuKubunCode.getコード());
            eucCsvEntity.set名称(suiteiKyufuKubunCode.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (TokkijikoTextImageKubun tokkijikoTextImageKubun : TokkijikoTextImageKubun.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("特記事項テキスト・イメージ区分"));
            eucCsvEntity.setコード(tokkijikoTextImageKubun.getコード());
            eucCsvEntity.set名称(tokkijikoTextImageKubun.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (NinteiChousaIraiKubunCode ninteiChousaIraiKubunCode : NinteiChousaIraiKubunCode.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("認定調査依頼区分コード"));
            eucCsvEntity.setコード(ninteiChousaIraiKubunCode.getコード());
            eucCsvEntity.set名称(ninteiChousaIraiKubunCode.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (ChosaKubun chosaKubun : ChosaKubun.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("調査区分"));
            eucCsvEntity.setコード(chosaKubun.getコード());
            eucCsvEntity.set名称(chosaKubun.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (ChosaJisshiBashoCode chosaJisshiBashoCode : ChosaJisshiBashoCode.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("調査実施場所コード"));
            eucCsvEntity.setコード(chosaJisshiBashoCode.getコード());
            eucCsvEntity.set名称(chosaJisshiBashoCode.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (ServiceKubunCode serviceKubunCode : ServiceKubunCode.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("現在のサービス区分コード"));
            eucCsvEntity.setコード(serviceKubunCode.getコード());
            eucCsvEntity.set名称(serviceKubunCode.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }

        return codeMasterEucCsvEntityList;

    }

    private void setEnumClassList(List<CodeMasterEucCsvEntity> codeMasterEucCsvEntityList) {
        for (IsShiryoSakuseiZumi isShiryoSakuseiZumi : IsShiryoSakuseiZumi.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("資料作成済区分"));
            if (isShiryoSakuseiZumi.is作成済()) {
                eucCsvEntity.setコード(new RString("1"));
            } else {
                eucCsvEntity.setコード(new RString("0"));
            }
            eucCsvEntity.set名称(isShiryoSakuseiZumi.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (IsShusseki isShusseki : IsShusseki.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("委員出席"));
            if (isShusseki.is委員出席()) {
                eucCsvEntity.setコード(new RString("1"));
            } else {
                eucCsvEntity.setコード(new RString("0"));
            }
            eucCsvEntity.set名称(isShusseki.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (IsChikokuUmu isChikokuUmu : IsChikokuUmu.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("委員遅刻有無"));
            if (isChikokuUmu.is委員遅刻()) {
                eucCsvEntity.setコード(new RString("1"));
            } else {
                eucCsvEntity.setコード(new RString("0"));
            }
            eucCsvEntity.set名称(isChikokuUmu.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (IssotaiUmu issotaiUmu : IssotaiUmu.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("委員早退有無"));
            if (issotaiUmu.is委員早退()) {
                eucCsvEntity.setコード(new RString("1"));
            } else {
                eucCsvEntity.setコード(new RString("0"));
            }
            eucCsvEntity.set名称(issotaiUmu.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (HanteiKekkaCode hanteiKekkaCode : HanteiKekkaCode.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("判定結果コード"));
            eucCsvEntity.setコード(hanteiKekkaCode.getコード());
            eucCsvEntity.set名称(hanteiKekkaCode.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (YokaigoJotaiKubun yokaigoJotaiKubun : YokaigoJotaiKubun.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("要介護状態区分コード"));
            eucCsvEntity.setコード(yokaigoJotaiKubun.getコード());
            eucCsvEntity.set名称(yokaigoJotaiKubun.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (YokaigoJotaiKubun02 yokaigoJotaiKubun02 : YokaigoJotaiKubun02.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("要介護状態区分コード02"));
            eucCsvEntity.setコード(yokaigoJotaiKubun02.getコード());
            eucCsvEntity.set名称(yokaigoJotaiKubun02.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (YokaigoJotaiKubun06 yokaigoJotaiKubun06 : YokaigoJotaiKubun06.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("要介護状態区分コード06"));
            eucCsvEntity.setコード(yokaigoJotaiKubun06.getコード());
            eucCsvEntity.set名称(yokaigoJotaiKubun06.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (YokaigoJotaiKubun09 yokaigoJotaiKubun09 : YokaigoJotaiKubun09.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("要介護状態区分コード09"));
            eucCsvEntity.setコード(yokaigoJotaiKubun09.getコード());
            eucCsvEntity.set名称(yokaigoJotaiKubun09.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (YokaigoJotaiKubun99 yokaigoJotaiKubun99 : YokaigoJotaiKubun99.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("要介護状態区分コード99"));
            eucCsvEntity.setコード(yokaigoJotaiKubun99.getコード());
            eucCsvEntity.set名称(yokaigoJotaiKubun99.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (GenponMaskKubun genponMaskKubun : GenponMaskKubun.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("原本マスク区分"));
            eucCsvEntity.setコード(genponMaskKubun.getコード());
            eucCsvEntity.set名称(genponMaskKubun.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (NinchishoNichijoSeikatsuJiritsudoCode ninchishoNichijo : NinchishoNichijoSeikatsuJiritsudoCode.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("認知症高齢者自立度コード"));
            eucCsvEntity.setコード(ninchishoNichijo.getコード());
            eucCsvEntity.set名称(ninchishoNichijo.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
        for (ShogaiNichijoSeikatsuJiritsudoCode shogaiNichijo : ShogaiNichijoSeikatsuJiritsudoCode.values()) {
            CodeMasterEucCsvEntity eucCsvEntity = new CodeMasterEucCsvEntity();
            eucCsvEntity.setコード種別(new RString("障害高齢者自立度コード"));
            eucCsvEntity.setコード(shogaiNichijo.getコード());
            eucCsvEntity.set名称(shogaiNichijo.get名称());
            codeMasterEucCsvEntityList.add(eucCsvEntity);
        }
    }

    private RString setDateFormat(RString date) {
        RString formatDate = RString.EMPTY;
        if (!RString.isNullOrEmpty(date)) {
            formatDate = new FlexibleDate(date).wareki().toDateString();
        }
        return formatDate;
    }

    private RString setYobuinNoFormat(RString yobuinNo) {
        RString formatYobuinNo = RString.EMPTY;
        if (!RString.isNullOrEmpty(yobuinNo)) {
            formatYobuinNo = new YubinNo(yobuinNo).getEditedYubinNo();
        }
        return formatYobuinNo;
    }

    private RString strToTime(RString str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        str = str.insert(2, ":");
        return RTime.parse(str).toFormattedTimeString(DisplayTimeFormat.HH_mm);
    }

    /**
     * 出力件数を取得するメッソドです。
     *
     * @param 出力件数 出力件数
     * @return RString
     */
    public RString get出力件数(Decimal 出力件数) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
        return builder.toRString();
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @param processParamter processParamter
     * @return List<RString> 出力条件List
     */
    public List<RString> get出力条件(ShinsaTaishoDataOutPutProcessParammeter processParamter) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(new RString("【開催番号】"));
        jokenBuilder.append(processParamter.getKaisaiBangou());
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }
}
