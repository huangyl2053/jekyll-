package jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichosakusei;

import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.HihokenshaDaichoDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.HihokenshaDaichoSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.RoreiFukushiNenkinJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokenshadaichosakusei.SeikatsuHogoJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.SetaiLeftEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.SetaiRightEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.ShoKofuKaishuDivisionSumEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳を管理するクラスです。
 *
 * @reamsid_L DBA-0500-010 suguangjun
 */
public class HihokenshaDaichoSakusei {

    private final HihokenshaDaichoSakuseiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 被保険者台帳Entity
     */
    public HihokenshaDaichoSakusei(HihokenshaDaichoSakuseiEntity entity) {
        this.entity = entity;
    }

    /**
     * 印刷日時を取得します。
     *
     * @return 印刷日時
     */
    public RString get印刷日時() {
        return entity.getPrintDate();
    }

    /**
     * ページ目を取得します。
     *
     * @return ページ目
     */
    public RString getページ目() {
        return entity.getPage();
    }

    /**
     * タイトルを取得します。
     *
     * @return タイトル
     */
    public RString getタイトル() {
        return entity.getTitle();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 市町村名称を取得します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 被保険者番号タイトルを取得します。
     *
     * @return 被保険者番号タイトル
     */
    public RString get被保険者番号タイトル() {
        return entity.getHihokenshaNoTitle();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 氏名カナを取得します。
     *
     * @return 氏名カナ
     */
    public AtenaKanaMeisho get氏名カナ() {
        return entity.getKanaMeisho();
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsuCode();
    }

    /**
     * 世帯コードを取得します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return entity.getSetaiCode();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public AtenaMeisho get氏名() {
        return entity.getMeisho();
    }

    /**
     * 状態を取得します。
     *
     * @return 状態
     */
    public RString get状態() {
        return entity.getState();
    }

    /**
     * 地区タイトル1を取得します。
     *
     * @return 地区タイトル1
     */
    public RString get地区タイトル1() {
        return entity.getChikucodeTitle1();
    }

    /**
     * 地区コード1を取得します。
     *
     * @return 地区コード1
     */
    public ChikuCode get地区コード1() {
        return entity.getChikuCode1();
    }

    /**
     * 地区タイトル2を取得します。
     *
     * @return 地区タイトル2
     */
    public RString get地区タイトル2() {
        return entity.getChikucodeTitle2();
    }

    /**
     * 地区コード2を取得します。
     *
     * @return 地区コード2
     */
    public ChikuCode get地区コード2() {
        return entity.getChikuCode2();
    }

    /**
     * 地区タイトル3を取得します。
     *
     * @return 地区タイトル3
     */
    public RString get地区タイトル3() {
        return entity.getChikucodeTitle3();
    }

    /**
     * 地区コード3を取得します。
     *
     * @return 地区コード3
     */
    public ChikuCode get地区コード3() {
        return entity.getChikuCode3();
    }

    /**
     * 電話番号タイトルを取得します。
     *
     * @return 電話番号タイトル
     */
    public RString get電話番号タイトル() {
        return entity.getTelephoneNoTitle();
    }

    /**
     * 電話番号１を取得します。
     *
     * @return 電話番号１
     */
    public RString get電話番号１() {
        return entity.getTelephoneNo1();
    }

    /**
     * 電話番号２を取得します。
     *
     * @return 電話番号２
     */
    public RString get電話番号２() {
        return entity.getTelephoneNo2();
    }

    /**
     * 住所タイトルを取得します。
     *
     * @return 住所タイトル
     */
    public RString get住所タイトル() {
        return entity.getJushoTitle();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.getJusho();
    }

    /**
     * 住所コードを取得します。
     *
     * @return 住所コード
     */
    public RString get住所コード() {
        return entity.getZenkokuJushoCode();
    }

    /**
     * 行政区タイトルを取得します。
     *
     * @return 行政区タイトル
     */
    public RString get行政区タイトル() {
        return entity.getGyoseikuTitle();
    }

    /**
     * 行政区コードを取得します。
     *
     * @return 行政区コード
     */
    public GyoseikuCode get行政区コード() {
        return entity.getGyoseikuCode();
    }

    /**
     * 事業者番号を取得します。
     *
     * @return 事業者番号
     */
    public RString get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 医療保険種別を取得します。
     *
     * @return 医療保険種別
     */
    public RString get医療保険種別() {
        return entity.getIryoHokenShubetsu();
    }

    /**
     * 医療保険者名称を取得します。
     *
     * @return 医療保険者名称
     */
    public RString get医療保険者名称() {
        return entity.getIryoHokenshaMeisho();
    }

    /**
     * 記号番号を取得します。
     *
     * @return 記号番号
     */
    public RString get記号番号() {
        return entity.getIryoHokenKigoNo();
    }

    /**
     * 順番号を取得します。
     *
     * @return 順番号
     */
    public RString get順番号() {
        return entity.getOrderNo();
    }

    /**
     * 措置保険者タイトルを取得します。
     *
     * @return 措置保険者タイトル
     */
    public RString get措置保険者タイトル() {
        return entity.getSochiHokensha();
    }

    /**
     * 旧保険者タイトルを取得します。
     *
     * @return 旧保険者タイトル
     */
    public RString get旧保険者タイトル() {
        return entity.getKyuHokensha();
    }

    /**
     * 資格異動情報を取得します。
     *
     * @return 資格異動情報
     */
    public HihokenshaDaichoDivisionEntity get資格異動情報() {
        return entity.get資格異動情報Entity();
    }

    /**
     * 生活保護情報を取得します。
     *
     * @return 生活保護情報
     */
    public SeikatsuHogoJukyushaDivisionEntity get生活保護情報() {
        return entity.get生活保護情報Entity();
    }

    /**
     * 老齢福祉情報を取得します。
     *
     * @return 老齢福祉情報
     */
    public RoreiFukushiNenkinJukyushaDivisionEntity get老齢福祉情報() {
        return entity.get老齢福祉情報Entity();
    }

    /**
     * 被保険者証発行履歴情報１を取得します。
     *
     * @return 被保険者証発行履歴情報１
     */
    public ShoKofuKaishuDivisionSumEntity get被保険者証発行履歴情報１() {
        return entity.get被保険者証発行履歴情報１();
    }

    /**
     * 被保険者証発行履歴情報2を取得します。
     *
     * @return 被保険者証発行履歴情報2
     */
    public ShoKofuKaishuDivisionSumEntity get被保険者証発行履歴情報2() {
        return entity.get被保険者証発行履歴情報２();
    }

    /**
     * 世帯氏名1を取得します。
     *
     * @return 世帯氏名1
     */
    public RString get世帯氏名1() {
        return entity.getSetaiName1();
    }

    /**
     * 世帯氏名2を取得します。
     *
     * @return 世帯氏名2
     */
    public RString get世帯氏名2() {
        return entity.getSetaiName2();
    }

    /**
     * 世帯氏名3を取得します。
     *
     * @return 世帯氏名3
     */
    public RString get世帯氏名3() {
        return entity.getSetaiName3();
    }

    /**
     * 世帯氏名4を取得します。
     *
     * @return 世帯氏名4
     */
    public RString get世帯氏名4() {
        return entity.getSetaiName4();
    }

    /**
     * 世帯氏名5を取得します。
     *
     * @return 世帯氏名5
     */
    public RString get世帯氏名5() {
        return entity.getSetaiName5();
    }

    /**
     * 世帯左情報を取得します。
     *
     * @return 世帯左情報
     */
    public SetaiLeftEntity get世帯左情報() {
        return entity.get世帯左情報();
    }

    /**
     * 世帯右情報を取得します。
     *
     * @return 世帯右情報
     */
    public SetaiRightEntity get世帯右情報() {
        return entity.get世帯右情報();
    }
}
