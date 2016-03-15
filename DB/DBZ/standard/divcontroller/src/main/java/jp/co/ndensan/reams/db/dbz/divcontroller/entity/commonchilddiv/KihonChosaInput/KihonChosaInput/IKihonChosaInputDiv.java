package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IKihonChosaInputDiv extends ICommonChildDivBaseProperties {

    /**
     * 共有子Divの状態を初期化します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 初期状態モード 初期状態モード
     */
    void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, RString 初期状態モード);

    /*
     * getDaiichigunShintaiKino
     * @return DaiichigunShintaiKino
     */
    public DaiichigunShintaiKinoDiv getDaiichigunShintaiKino();

    /*
     * getSeikatsuKinou
     * @return SeikatsuKinou
     */
    public SeikatsuKinouDiv getSeikatsuKinou();

    /*
     * getNinchiKinou
     * @return NinchiKinou
     */
    public NinchiKinouDiv getNinchiKinou();

    /*
     * getKoudoShogai
     * @return KoudoShogai
     */
    public KoudoShogaiDiv getKoudoShogai();

    /*
     * getShakaiSekatsu
     * @return ShakaiSekatsu
     */
    @JsonProperty("ShakaiSekatsu")
    public ShakaiSekatsuDiv getShakaiSekatsu();

    /*
     * getTokubetsuIryo
     * @return TokubetsuIryo
     */
    @JsonProperty("TokubetsuIryo")
    public TokubetsuIryoDiv getTokubetsuIryo();

    /*
     * getJiritsudo
     * @return Jiritsudo
     */
    public JiritsudoDiv getJiritsudo();

}
