/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinchishoKoreishaNichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunHorei;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiYukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShogaiKoreiNichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnRshareSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 介護保険受給者Entityクラスです
 *
 * @author N2806 太田 智之
 * @jpName 介護保険受給者エンティティ
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
@OnRshareSchema
public class KaigohokenJukyushaEntity implements IDbAccessable {

    // TODO N2806太田智之 公開用view構造が決まった段階で見直しが必要
    /**
     * 生活保護受給者テーブル
     */
    @TableName
    public static final RString TABLE_NAME = new RString("XXXX");
    @PrimaryKey
    private RString 識別コード;
    private RString 介護被保険者番号;
    private RString 申請番号;
    private NinteiShinseiYukoKubun 申請有効区分;
    private RDate 申請年月日;
    private NinteiShinseiKubunShinsei 申請時申請区分;
    private NinteiShinseiKubunHorei 法令申請区分;
    private RString 認定申請理由;
    private RString 地方自治体コード;
    private TorisageKubun 取下げ区分;
    private RDate 依頼年月日;
    private RDate 実施年月日;
    private RDate 完了年月日;
    private RString 事業者名称;
    private RString 調査委託先コード;
    private RString 認定調査員コード;
    private RString 認定調査員氏名;
    private RDate 作成依頼年月日;
    private RDate 受領年月日;
    private ShogaiKoreiNichijoSeikatsuJiritsudo 障害高齢者生活自立度;
    private NinchishoKoreishaNichijoSeikatsuJiritsudo 認知症高齢者生活自立度;
    private RString 主治医氏名;
    private RString 主治医医師識別コード;
    private RString 医療機関名称;
    private RString 医療機関コード;
    private RString 一時判定_要介護状態区分;
    private RDate 判定年月日;
    private RString 認知症加算_要介護状態区分;
    private RDate 資料作成年月日;
    private RDate 回答年月日;
    private RDate 開催予定年月日;
    private int 合議体番号;
    private RDate 認定年月日;
    private RString 要介護状態区分;
    private RDate 有効開始年月日;
    private RDate 有効終了年月日;
    private RString 審査会意見;
    private RDate 異動年月日;
    private RString 特定疾病;
    private RDate 喪失年月日;

    /**
     * コンストラクタです。
     */
    public KaigohokenJukyushaEntity() {
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return 識別コード;
    }

    /**
     * 介護被保険者番号を返します。
     *
     * @return 介護被保険者番号
     */
    public RString get介護被保険者番号() {
        return 介護被保険者番号;
    }

    /**
     * 申請番号を返します。
     *
     * @return 申請番号
     */
    public RString get申請番号() {
        return 申請番号;
    }

    /**
     * 申請有効区分を返します。
     *
     * @return 申請有効区分
     */
    public NinteiShinseiYukoKubun get申請有効区分() {
        return 申請有効区分;
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public RDate get申請年月日() {
        return 申請年月日;
    }

    /**
     * 申請時申請区分を返します。
     *
     * @return 申請時申請区分
     */
    public NinteiShinseiKubunShinsei get申請時申請区分() {
        return 申請時申請区分;
    }

    /**
     * 法令申請区分を返します。
     *
     * @return 法令申請区分
     */
    public NinteiShinseiKubunHorei get法令申請区分() {
        return 法令申請区分;
    }

    /**
     * 認定申請理由を返します。
     *
     * @return 認定申請理由
     */
    public RString get認定申請理由() {
        return 認定申請理由;
    }

    /**
     * 地方自治体コードを返します。
     *
     * @return　地方自治体コード
     */
    public RString get地方自治体コード() {
        return 地方自治体コード;
    }

    /**
     * 依頼年月日を返します。
     *
     * @return 依頼年月日
     */
    public RDate get依頼年月日() {
        return 依頼年月日;
    }

    /**
     * 取下げ区分を返します。
     *
     * @return 取下げ区分
     */
    public TorisageKubun get取下げ区分() {
        return 取下げ区分;
    }

    /**
     * 実施年月日を返します。
     *
     * @return 実施年月日
     */
    public RDate get実施年月日() {
        return 実施年月日;
    }

    /**
     * 完了年月日を返します。
     *
     * @return 完了年月日
     */
    public RDate get完了年月日() {
        return 完了年月日;
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return 事業者名称;
    }

    /**
     * 調査委託先コードを返します。
     *
     * @return 調査委託先コード
     */
    public RString get調査委託先コード() {
        return 調査委託先コード;
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return 認定調査員コード;
    }

    /**
     * 認定調査員氏名を返します。
     *
     * @return 認定調査員氏名
     */
    public RString get認定調査員氏名() {
        return 認定調査員氏名;
    }

    /**
     * 作成依頼年月日を返します。
     *
     * @return 作成依頼年月日
     */
    public RDate get作成依頼年月日() {
        return 作成依頼年月日;
    }

    /**
     * 受領年月日を返します。
     *
     * @return 受領年月日
     */
    public RDate get受領年月日() {
        return 受領年月日;
    }

    /**
     * 障害高齢者生活自立度を返します。
     *
     * @return 障害高齢者生活自立度
     */
    public ShogaiKoreiNichijoSeikatsuJiritsudo get障害高齢者生活自立度() {
        return 障害高齢者生活自立度;
    }

    /**
     * 認知症高齢者生活自立度を返します。
     *
     * @return 認知症高齢者生活自立度
     */
    public NinchishoKoreishaNichijoSeikatsuJiritsudo get認知症高齢者生活自立度() {
        return 認知症高齢者生活自立度;
    }

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return 主治医氏名;
    }

    /**
     * 主治医医師識別コードを返します。
     *
     * @return 主治医医師識別コード
     */
    public RString get主治医医師識別コード() {
        return 主治医医師識別コード;
    }

    /**
     * 医療機関名称を返します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return 医療機関名称;
    }

    /**
     * 医療機関コードを返します。
     *
     * @return 医療機関コード
     */
    public RString get医療機関コード() {
        return 医療機関コード;
    }

    /**
     * 一時判定_要介護状態区分を返します。
     *
     * @return 一時判定_要介護状態区分
     */
    public RString get一時判定_要介護状態区分() {
        return 一時判定_要介護状態区分;
    }

    /**
     * 判定年月日を返します。
     *
     * @return 判定年月日
     */
    public RDate get判定年月日() {
        return 判定年月日;
    }

    /**
     * 認知症加算_要介護状態区分を返します。
     *
     * @return 認知症加算_要介護状態区分
     */
    public RString get認知症加算_要介護状態区分() {
        return 認知症加算_要介護状態区分;
    }

    /**
     * 資料作成年月日を返します。
     *
     * @return 資料作成年月日
     */
    public RDate get資料作成年月日() {
        return 資料作成年月日;
    }

    /**
     * 回答年月日を返します。
     *
     * @return 回答年月日
     */
    public RDate get回答年月日() {
        return 回答年月日;
    }

    /**
     * 開催予定年月日を返します。
     *
     * @return 開催予定年月日
     */
    public RDate get開催予定年月日() {
        return 開催予定年月日;
    }

    /**
     * 異動年月日を返します。
     *
     * @return 異動年月日
     */
    public RDate get異動年月日() {
        return 異動年月日;
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return 合議体番号;
    }

    /**
     * 認定年月日を返します。
     *
     * @return 認定年月日
     */
    public RDate get認定年月日() {
        return 認定年月日;
    }

    /**
     * 要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    public RString get要介護状態区分() {
        return 要介護状態区分;
    }

    /**
     * 有効開始年月日を返します。
     *
     * @return 有効開始年月日
     */
    public RDate get有効開始年月日() {
        return 有効開始年月日;
    }

    /**
     * 有効終了年月日を返します。
     *
     * @return 有効終了年月日
     */
    public RDate get有効終了年月日() {
        return 有効終了年月日;
    }

    /**
     * 審査会意見を返します。
     *
     * @return 審査会意見
     */
    public RString get審査会意見() {
        return 審査会意見;
    }

    /**
     * 特定疾病を返します。
     *
     * @return 特定疾病
     */
    public RString get特定疾病() {
        return 特定疾病;
    }

    /**
     * 喪失年月日を返します。
     *
     * @return 喪失年月日
     */
    public RDate get喪失年月日() {
        return 喪失年月日;
    }

    /**
     * 識別コードをセットします。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(RString 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * b介護被保険者番号をセットします。
     *
     * @param b介護被保険者番号 b介護被保険者番号
     */
    public void setB介護被保険者番号(RString b介護被保険者番号) {
        this.介護被保険者番号 = b介護被保険者番号;
    }

    /**
     * c申請番号をセットします。
     *
     * @param c申請番号 c申請番号
     */
    public void setC申請番号(RString c申請番号) {
        this.申請番号 = c申請番号;
    }

    /**
     * 申請有効区分をセットします。
     *
     * @param 申請有効区分 申請有効区分
     */
    public void set申請有効区分(NinteiShinseiYukoKubun 申請有効区分) {
        this.申請有効区分 = 申請有効区分;
    }

    /**
     * 申請年月日をセットします。
     *
     * @param 申請年月日 申請年月日
     */
    public void set申請年月日(RDate 申請年月日) {
        this.申請年月日 = 申請年月日;
    }

    /**
     * 申請時申請区分をセットします。
     *
     * @param 申請時申請区分 申請時申請区分
     */
    public void set申請時申請区分(NinteiShinseiKubunShinsei 申請時申請区分) {
        this.申請時申請区分 = 申請時申請区分;
    }

    /**
     * 法令申請区分をセットします。
     *
     * @param 法令申請区分 法令申請区分
     */
    public void set法令申請区分(NinteiShinseiKubunHorei 法令申請区分) {
        this.法令申請区分 = 法令申請区分;
    }

    /**
     * 認定申請理由をセットします。
     *
     * @param 認定申請理由 認定申請理由
     */
    public void set認定申請理由(RString 認定申請理由) {
        this.認定申請理由 = 認定申請理由;
    }

    /**
     * 地方自治体コードをセットします。
     *
     * @param 地方自治体コード 地方自治体コード
     */
    public void set地方自治体コード(RString 地方自治体コード) {
        this.地方自治体コード = 地方自治体コード;
    }

    /**
     * 依頼年月日をセットします。
     *
     * @param 依頼年月日 依頼年月日
     */
    public void set依頼年月日(RDate 依頼年月日) {
        this.依頼年月日 = 依頼年月日;
    }

    /**
     * 取下げ区分をセットします。
     *
     * @param 取下げ区分 取下げ区分
     */
    public void set取下げ区分(TorisageKubun 取下げ区分) {
        this.取下げ区分 = 取下げ区分;
    }

    /**
     * 実施年月日をセットします。
     *
     * @param 実施年月日 実施年月日
     */
    public void set実施年月日(RDate 実施年月日) {
        this.実施年月日 = 実施年月日;
    }

    /**
     * 完了年月日をセットします。
     *
     * @param 完了年月日 完了年月日
     */
    public void set完了年月日(RDate 完了年月日) {
        this.完了年月日 = 完了年月日;
    }

    /**
     * 事業者名称をセットします。
     *
     * @param 事業者名称 事業者名称
     */
    public void set事業者名称(RString 事業者名称) {
        this.事業者名称 = 事業者名称;
    }

    /**
     * 調査委託先コードをセットします。
     *
     * @param 調査委託先コード 調査委託先コード
     */
    public void set調査委託先コード(RString 調査委託先コード) {
        this.調査委託先コード = 調査委託先コード;
    }

    /**
     * 認定調査員コードをセットします。
     *
     * @param 認定調査員コード 認定調査員コード
     */
    public void set認定調査員コード(RString 認定調査員コード) {
        this.認定調査員コード = 認定調査員コード;
    }

    /**
     * 認定調査員氏名をセットします。
     *
     * @param 認定調査員氏名 認定調査員氏名
     */
    public void set認定調査員氏名(RString 認定調査員氏名) {
        this.認定調査員氏名 = 認定調査員氏名;
    }

    /**
     * 作成依頼年月日をセットします。
     *
     * @param 作成依頼年月日 作成依頼年月日
     */
    public void set作成依頼年月日(RDate 作成依頼年月日) {
        this.作成依頼年月日 = 作成依頼年月日;
    }

    /**
     * 受領年月日をセットします。
     *
     * @param 受領年月日 受領年月日
     */
    public void set受領年月日(RDate 受領年月日) {
        this.受領年月日 = 受領年月日;
    }

    /**
     * 障害高齢者生活自立度をセットします。
     *
     * @param 障害高齢者生活自立度 障害高齢者生活自立度
     */
    public void set障害高齢者生活自立度(ShogaiKoreiNichijoSeikatsuJiritsudo 障害高齢者生活自立度) {
        this.障害高齢者生活自立度 = 障害高齢者生活自立度;
    }

    /**
     * 認知症高齢者生活自立度をセットします。
     *
     * @param 認知症高齢者生活自立度 認知症高齢者生活自立度
     */
    public void set認知症高齢者生活自立度(NinchishoKoreishaNichijoSeikatsuJiritsudo 認知症高齢者生活自立度) {
        this.認知症高齢者生活自立度 = 認知症高齢者生活自立度;
    }

    /**
     * 主治医氏名をセットします。
     *
     * @param 主治医氏名 主治医氏名
     */
    public void set主治医氏名(RString 主治医氏名) {
        this.主治医氏名 = 主治医氏名;
    }

    /**
     * 主治医医師識別コードをセットします。
     *
     * @param 主治医医師識別コード 主治医医師識別コード
     */
    public void set主治医医師識別コード(RString 主治医医師識別コード) {
        this.主治医医師識別コード = 主治医医師識別コード;
    }

    /**
     * 医療機関名称をセットします。
     *
     * @param 医療機関名称 医療機関名称
     */
    public void set医療機関名称(RString 医療機関名称) {
        this.医療機関名称 = 医療機関名称;
    }

    /**
     * 医療機関コードをセットします。
     *
     * @param 医療機関コード 医療機関コード
     */
    public void set医療機関コード(RString 医療機関コード) {
        this.医療機関コード = 医療機関コード;
    }

    /**
     * 一時判定_要介護状態区分をセットします。
     *
     * @param 一時判定_要介護状態区分 一時判定_要介護状態区分
     */
    public void set一時判定_要介護状態区分(RString 一時判定_要介護状態区分) {
        this.一時判定_要介護状態区分 = 一時判定_要介護状態区分;
    }

    /**
     * 判定年月日をセットします。
     *
     * @param 判定年月日 判定年月日
     */
    public void set判定年月日(RDate 判定年月日) {
        this.判定年月日 = 判定年月日;
    }

    /**
     * 認知症加算_要介護状態区分をセットします。
     *
     * @param 認知症加算_要介護状態区分 認知症加算_要介護状態区分
     */
    public void set認知症加算_要介護状態区分(RString 認知症加算_要介護状態区分) {
        this.認知症加算_要介護状態区分 = 認知症加算_要介護状態区分;
    }

    /**
     * 資料作成年月日をセットします。
     *
     * @param 資料作成年月日 資料作成年月日
     */
    public void set資料作成年月日(RDate 資料作成年月日) {
        this.資料作成年月日 = 資料作成年月日;
    }

    /**
     * 回答年月日をセットします。
     *
     * @param 回答年月日 回答年月日
     */
    public void set回答年月日(RDate 回答年月日) {
        this.回答年月日 = 回答年月日;
    }

    /**
     * 開催予定年月日をセットします。
     *
     * @param 開催予定年月日 開催予定年月日
     */
    public void set開催予定年月日(RDate 開催予定年月日) {
        this.開催予定年月日 = 開催予定年月日;
    }

    /**
     * 異動年月日をセットします。
     *
     * @param 異動年月日 異動年月日
     */
    public void set異動年月日(RDate 異動年月日) {
        this.異動年月日 = 異動年月日;
    }

    /**
     * 合議体番号をセットします。
     *
     * @param 合議体番号 合議体番号
     */
    public void set合議体番号(int 合議体番号) {
        this.合議体番号 = 合議体番号;
    }

    /**
     * 認定年月日をセットします。
     *
     * @param 認定年月日 認定年月日
     */
    public void set認定年月日(RDate 認定年月日) {
        this.認定年月日 = 認定年月日;
    }

    /**
     * 要介護状態区分をセットします。
     *
     * @param 要介護状態区分 要介護状態区分
     */
    public void set要介護状態区分(RString 要介護状態区分) {
        this.要介護状態区分 = 要介護状態区分;
    }

    /**
     * 有効開始年月日をセットします。
     *
     * @param 有効開始年月日 有効開始年月日
     */
    public void set有効開始年月日(RDate 有効開始年月日) {
        this.有効開始年月日 = 有効開始年月日;
    }

    /**
     * 有効終了年月日をセットします。
     *
     * @param 有効終了年月日 有効終了年月日
     */
    public void set有効終了年月日(RDate 有効終了年月日) {
        this.有効終了年月日 = 有効終了年月日;
    }

    /**
     * 審査会意見をセットします。
     *
     * @param 審査会意見 審査会意見
     */
    public void set審査会意見(RString 審査会意見) {
        this.審査会意見 = 審査会意見;
    }

    /**
     * 特定疾病をセットします。
     *
     * @param 特定疾病
     */
    public void set特定疾病(RString 特定疾病) {
        this.特定疾病 = 特定疾病;
    }

    /**
     * 喪失年月日をセットします。
     *
     * @param 喪失年月日 喪失年月日
     */
    public void set喪失年月日(RDate 喪失年月日) {
        this.喪失年月日 = 喪失年月日;
    }
}
